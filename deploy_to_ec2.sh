#!/bin/bash
# nginx 가 꺼져 있다면  == 초기 세팅 단계라면, project를 처음부터 다시 build 한다

COMPOSE_FILE="docker-compose.ec2.yml"
NGINX_CONF_DEFAULT="./nginx/nginx-ec2.conf"
NGINX_CONF_1="./nginx/nginx-ec2-1.conf"
NGINX_CONF_2="./nginx/nginx-ec2-2.conf"

init_build_folder() {
  docker exec -i frontend sh -c '
      cp -rf /frontend/dist/* /frontend/volume/
    '
  docker-compose -f $COMPOSE_FILE down frontend
}

reload_nginx() {
  cp -rf "$1" $NGINX_CONF_DEFAULT
    docker exec -i nginx sh -c '
      nginx -s reload && exit
    '
}

# backend1 이 켜져 있으면 0
# backend2 가 켜져 있으면 1
# 둘 다 꺼져 있으면 2
check_backend_state() {
  if docker-compose -f $COMPOSE_FILE  ps backend1 | grep "Up"; then
    backend_state=0
  elif docker-compose -f $COMPOSE_FILE  ps backend2 | grep "Up"; then
    backend_state=1
  else
    backend_state=2
  fi
  return "$backend_state"
}

# nginx 가 켜져있지 않다면 == 프로젝트가 한 번도 실행된 적 없거나, 문제가 생겼다면
if ! docker-compose -f $COMPOSE_FILE  ps nginx | grep "Up"; then
  sudo docker-compose -f $COMPOSE_FILE down
  sudo docker-compose -f $COMPOSE_FILE up -d

  # build_folder 세팅
  init_build_folder

  # backend 8080 port 로 설정하고 reload
  reload_nginx $NGINX_CONF_1

  # 빌드 이후에는 frontend 와 backend2 서버를 종료한다
  docker-compose -f $COMPOSE_FILE down frontend
  docker-compose -f $COMPOSE_FILE down backend2

# nginx 가 정상 동작하고 있다면 == 아예 초기 세팅 단계가 아니라면
else
  # frontend 를 다시 build
  docker-compose -f $COMPOSE_FILE pull frontend
  docker-compose -f $COMPOSE_FILE up --wait -d frontend

  # build_folder 세팅
  init_build_folder

  #
  check_backend_state
  backend_state=$?

  # backend 가 완전히 동작하기 전에 nginx 설정을 바꾸게 되면 오류가 날 수 있다
  # 때문에, --wait 설정을 이용하여 backend 의 HealthCheck 를 추가해 주었다
  case $backend_state in
    # backend1 이 켜져 있음
    # backend2 를 build 해서 켜고 nginx 를 reload
    # 그 후, backend1 종료
  	0)
      docker-compose -f $COMPOSE_FILE pull backend2
      docker-compose -f $COMPOSE_FILE up --wait -d backend2
      reload_nginx $NGINX_CONF_2
      docker-compose -f $COMPOSE_FILE down backend1
      ;;
    # backend2 가 켜져 있음
    # backend1 를 build 해서 켜고 nginx 를 reload
    # 그 후, backend1 종료
    1)
      docker-compose -f $COMPOSE_FILE pull backend1
      docker-compose -f $COMPOSE_FILE up --wait -d backend1
      reload_nginx $NGINX_CONF_1
      docker-compose -f $COMPOSE_FILE down backend2
      ;;
    # backend1, backend2 모두 꺼져 있음
    # 정상적인 동작과정에서는 일어날 수 없는 상황임
    # backend1을 build 하고 동작시킨다
    2)
      docker-compose -f $COMPOSE_FILE pull backend1
      docker-compose -f $COMPOSE_FILE up --wait -d backend1
      reload_nginx $NGINX_CONF_1
      ;;
  esac
fi




