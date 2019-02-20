FROM java:8-jre


ADD ./target/EurekaServer-0.0.1-SNAPSHOT.jar /app/EurekaServer-0.0.1-SNAPSHOT.jar

WORKDIR app
ENTRYPOINT ["java" , "-jar" , "EurekaServer-0.0.1-SNAPSHOT.jar"]-

HEALTHCHECK --interval=10s --timeout=5s CMD curl -f http://localhost:8761/health || exit 1

EXPOSE 8761