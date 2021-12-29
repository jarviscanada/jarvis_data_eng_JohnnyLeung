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

#Save CPU architecture information to a variable
lscpu_out=`lscpu`

#Retrieve hardware specification variables
hostname=$(hostname -f)
cpu_number=$(echo "$lscpu_out" | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out" | egrep "^Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | egrep "^Model name:" | awk '{$1="";$2="";print}' | xargs)
cpu_mhz=$(echo "$lscpu_out" | egrep "^CPU MHz:" | awk '{print $3}' | xargs)
L2_cache=$(echo "$lscpu_out"  | egrep "(L2)\s(cache)" | awk '{print $3}' | sed 's/.$//' | xargs)
total_mem=$(cat /proc/meminfo | egrep "MemTotal:" | awk '{print $2}' | xargs)

