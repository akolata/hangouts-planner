# API Gateway

## Maven

### Build .jar
```shell
mvn -DskipTests clean package
```

## Docker

### Build image
```shell
docker build . \
  --tag hangouts-planner/api-gateway:latest
```

### Run image
```shell
docker run \
  --rm \
  --name=hangouts-planner-api-gateway \
  -p 8080:8080 \
  hangouts-planner/api-gateway:latest
```