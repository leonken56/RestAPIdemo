FROM openjdk:latest
ADD target/bank-docker.jar bank-docker.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","bank-docker.jar"]
