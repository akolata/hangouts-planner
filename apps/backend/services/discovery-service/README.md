# Discovery Service

## Maven

### Build .jar
```shell
mvn -DskipTests clean package
```

## Docker

### Build image
```shell
docker build . \
  --tag hangouts-planner/discovery-service:latest
```

### Run image
```shell
docker run \
  --rm \
  --name=hangouts-planner-discovery-service \
  -p 8761:8761 \
  hangouts-planner/discovery-service:latest
```