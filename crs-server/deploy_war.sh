#!/bin/bash
#run: chmod u+x deploy_war.sh     if permission denied error comes up


PROJECT="crs-server"
SRC_FILE="target/"$PROJECT".war"

WEB_DIR="/var/lib/tomcat8/webapps/"
PROJ_DIR=$WEB_DIR$PROJECT
TRG_WAR=$PROJ_DIR".war"

mvn clean install;
mvn package;
sudo rm -rf $TRG_WAR
sudo rm -rf $PROJ_DIR
sudo cp $SRC_FILE $TRG_WAR
sudo mv /var/log/tomcat8/catalina.out /var/log/tomcat8/catalina-`date +%Y_%m_%d_%H:%M:%S`.bak
echo 
echo "********************** deploying on tomcat"
echo "src_file = "$SRC_FILE
echo
sudo service tomcat8 restart

