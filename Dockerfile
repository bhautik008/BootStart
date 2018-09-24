FROM openjdk:8
EXPOSE 8086
ADD target/BootStart-0.0.1-SNAPSHOT.jar bootStart.jar
ENTRYPOINT ["java", "-jar", "bootStart.jar"]
