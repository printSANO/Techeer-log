#!/bin/bash

# shell 실행 전 docker hub 에 로그인 해야함

# 이미지 빌드
docker-compose -f docker-compose.deploy.yml build

# 이미지에 태그 부여
docker tag console-log-nginx:latest jaebin19/console-log:nginx
docker tag console-log-backend:latest jaebin19/console-log:backend
docker tag console-log-frontend:latest jaebin19/console-log:frontend

# Docker Hub에 푸시
docker push jaebin19/console-log:nginx
docker push jaebin19/console-log:backend
docker push jaebin19/console-log:frontend
