#!/usr/bin/env bash

REPOSITORY=/home/ec2-user/Console-log
COMPOSE_FILE=docker-compose.deploy.yml
#ELK_COMPOSE_FILE=docker-compose.elk.yml
APP_NAME=Console-log

# Change to the repository directory
cd $REPOSITORY

#docker rm -f $(docker ps -aq) || docker rmi -f $(docker images -aq) || docker volume rm $(docker volume ls -q) || find . -path "*/migrations/*.py" -delete

#yes | ./init-letsencrypt.sh
docker-compose -f $COMPOSE_FILE up -d
# docker-compose -f $ELK_COMPOSE_FILE up -d