FROM openjdk:8-jdk-alpine

MAINTAINER Cristian Moreno - cristian.moreno@cmtekprojects.com

ADD /target/*.jar between-proof-backend.jar

ENTRYPOINT ["java","-jar","between-proof-backend.jar"]
