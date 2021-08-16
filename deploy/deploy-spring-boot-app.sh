#!/usr/bin/env sh

echo "!------ Installing software ------!"
apt update
apt install -y mysql-server openjdk-11-jdk maven nginx

echo "!------ Configuring MySQL user ------!"
mysql -u root -proot <<EOF
CREATE USER 'olegilminsky'@'localhost' IDENTIFIED BY 'olegilminsky';
GRANT ALL PRIVILEGES ON * . * TO 'olegilminsky'@'localhost';
FLUSH PRIVILEGES;
EOF

echo "!------ Building Spring Boot application ------!"
cd ..

mvn clean install

mkdir -p /opt/webapp || exit
cp ////app.jar /opt/webapp/app.jar
chmod 500 /opt/webapp/app.jar

echo "!------ Creating a systemctl daemon descriptor ------!"
cd deploy || exit

cp spring-boot-app.service /etc/systemd/system/spring-boot-app.service

echo "!------ Running the new daemon ------!"
systemctl daemon-reload
systemctl start spring-boot-app

echo "!------ Configuring NGINX ------!"
cp application.nginx.conf /etc/nginx/sites-avaliable/default
systemctl restart nginx