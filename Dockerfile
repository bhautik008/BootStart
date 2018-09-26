FROM openjdk:8
VOLUME /tmp
EXPOSE 5000
ADD target/BootStart-0.0.1-SNAPSHOT.jar bootStart.jar
ENTRYPOINT ["java", "-jar", "bootStart.jar"]
