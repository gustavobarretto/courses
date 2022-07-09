#!/bin/bash

echo "docker-compose down"
docker-compose down
echo "docker-compose rm -f"
docker-compose rm -f

echo "build"
cd api-gateway
mvn clean package -DskipTests
cd ..
cd catalog-service
mvn clean package -DskipTests
cd ..
cd eureka-service
mvn clean package -DskipTests
cd ..
cd movie-service
mvn clean package -DskipTests
cd ..
cd server-config
mvn clean package -DskipTests
cd ..

echo "docker-compose build"
docker-compose build

echo "docker-compose up"
docker-compose up