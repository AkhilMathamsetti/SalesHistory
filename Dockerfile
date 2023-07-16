FROM openjdk:11
EXPOSE 8080
COPY target/sh.jar sh.jar
ENTRYPOINT ["java","-jar","sh.jar"]
