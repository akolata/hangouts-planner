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
  --tag hangouts-planner/meeting-service:latest
```

### Run image
```shell
docker run \
  --rm \
  --name=hangouts-planner-meeting-service \
  -e SERVER_PORT=8082 \
  -p 8082:8082 \
  hangouts-planner/meeting-service:latest
```

## OpenAPI

### /v3/api-docs
http://localhost:${SERVER_PORT}/v3/api-docs   

### swagger-ui.html
http://127.0.0.1:${SERVER_PORT}/swagger-ui.html

### Web
http://localhost:${SERVER_PORT}/swagger-ui.html
