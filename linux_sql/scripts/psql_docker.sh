#!/bin/sh

#capture CLI arguments
cmd=$1
db_username=$2
db_password=$3

#Start docker
sudo systemctl status docker > /dev/null || systemctl start docker

#check container status
docker container inspect jrvs-psql &> /dev/null

#User switch case to handle create|stop|start options
case $cmd in
  create)

  # Check if the container is already created
  if [ $? -eq 0 ]; then
    echo 'Container already exists'
    exit 0
  fi
  
  echo $#
  #check # of CLI arguments
  if [ $# -ne 3 ]; then
    echo 'Create requires username and password'
    exit 1
  fi

  #Create container
  docker volume create pgdata
  docker run --name jrvs-psql -e POSTGRES_PASSWORD=$db_password -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres:9.6-alpine
  exit $?
  ;;

  start|stop)
  #check instance status; exit 1 if container has not been created
  if [ $? -ne 0 ]; then
    echo 'Container has not been created'
    exit 1
  fi

  #Start or stop the container
  docker container $cmd jrvs-psql
  exit $?
  ;;

  *)
  echo 'Illegal command'
  echo 'Commands: start|stop|create'
  exit 1
  ;;
esac
