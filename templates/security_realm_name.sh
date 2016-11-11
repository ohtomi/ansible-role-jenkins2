#!/bin/bash

config_file_path="/var/lib/jenkins/config.xml"
need_not_login="hudson.security.SecurityRealm\$None"

if [ ! -f $config_file_path ]; then
    echo $need_not_login
    exit
fi

security_realm_rows=`grep "<securityRealm class" $config_file_path`
security_realm_rows_count=`echo $security_realm_rows | wc -l`

if [ $security_realm_rows_count -eq 0 ]; then
    echo $need_not_login
elif [ $security_realm_rows_count -eq 1 ]; then
    security_realm_name=`echo $security_realm_rows | sed -n 's/.*<securityRealm class="\([^"]*\)"\/>.*/\1/p'`
    echo $security_realm_name
else
    echo "More then one Security Realm are found."
    exit 1
fi
