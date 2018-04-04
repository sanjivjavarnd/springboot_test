#Dockerfile
FROM openjdk:8-jdk-alpine
MAINTAINER Author sanjiv.javarnd@gmail.com
#RUN 
#ADD 
WORKDIR /tmp
ADD /target/dockertest-0.0.1-SNAPSHOT.jar  /tmp/dockertest-0.0.1-SNAPSHOT.jar
VOLUME /tmp
#COPY /target/dockertest-0.0.1-SNAPSHOT.jar  /tmp/target/dockertest-0.0.1-SNAPSHOT.jar
#CMD ["cd" "/tmp/"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tmp/dockertest-0.0.1-SNAPSHOT.jar"]
CMD ["-start"]
EXPOSE 80