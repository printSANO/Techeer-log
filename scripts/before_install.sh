#!/usr/bin/env bash

REPOSITORY=/home/ec2-user/Console-log
COMPOSE_FILE=docker-compose.deploy.yml
#ELK_COMPOSE_FILE=docker-compose.elk.yml
APP_NAME=Console-log

# Change to the repository directory
cd $REPOSITORY


docker-compose -f $COMPOSE_FILE down -v --rmi "all"
# docker-compose -f $ELK_COMPOSE_FILE down -v --rmi "all"
yes | docker system prune -a