FROM eclipse-temurin:17-jre-jammy

COPY scripts/docker_init.sh /docker_init.sh
RUN chmod +x /docker_init.sh

COPY build/libs/graphql-server-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app

CMD /docker_init.sh /app/app.jar
