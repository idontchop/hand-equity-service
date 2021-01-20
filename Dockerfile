FROM openjdk:12
WORKDIR /
ADD target/hand-equity-service-0.0.1-SNAPSHOT.jar hand-equity-service-0.0.1-SNAPSHOT.jar
RUN mkdir -p /root/.ssh
CMD java -jar -Dspring.profiles.active=prod hand-equity-service-0.0.1-SNAPSHOT.jar
EXPOSE 9234


