FROM eclipse-temurin:17-jdk
MAINTAINER "Ramandeep Singh <Ramandeep55>"
COPY target/22-SB-Docker-0.0.1-SNAPSHOT.jar /user/app/
WORKDIR /user/app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar","22-SB-Docker-0.0.1-SNAPSHOT.jar"]