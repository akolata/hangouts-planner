FROM openjdk:17-slim as builder
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17-jre-alpine

ENV USER="app"
ENV UID="10001"
ENV GID="20002"
ENV JDK_JAVA_OPTIONS="-Xms256m -Xmx512m"

RUN apk --no-cache add bash curl

RUN mkdir /app
RUN addgroup ${USER} --gid ${GID}
RUN adduser --system --disabled-password --home /var/cache/${USER} --ingroup ${USER} --shell /sbin/nologin ${USER} --uid ${UID}

WORKDIR /app

COPY --from=builder dependencies/ /app
COPY --from=builder spring-boot-loader/ /app
COPY --from=builder snapshot-dependencies/ /app
COPY --from=builder application/ /app

RUN chown -R ${USER}:${USER} .
USER ${USER}

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-cp", "BOOT-INF/classes:BOOT-INF/lib/*", "com.hangoutsplanner.service.configservice.ConfigServiceApplication"]
