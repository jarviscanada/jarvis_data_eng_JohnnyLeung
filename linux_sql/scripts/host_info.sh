#!/bin/sh
#Setup and validate arguments
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5
#Check # of args
if [ $# -ne 5 ]; then
  echo 'host_info requires 5 arguments'
  exit 1
fi
