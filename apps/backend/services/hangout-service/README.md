# Hangout Service

## Maven

### Build .jar
```shell
mvn -DskipTests clean package
```

## Docker

### Build image
```shell
docker build . \
  --tag hangouts-planner/hangout-service:latest
```

### Run image
```shell
docker run \
  --rm \
  --name=hangouts-planner-hangout-service \
  -e SERVER_PORT=8081 \
  -p 8081:8081 \
  hangouts-planner/hangout-service:latest
```