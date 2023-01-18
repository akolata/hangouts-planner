# Config Service

## Maven

### Build .jar
```shell
mvn -DskipTests clean package
```

## Docker

### Build image
```shell
docker build . \
  --tag hangouts-planner/config-service:latest
```

### Run image
```shell
docker run \
  --rm \
  --name=hangouts-planner-config-service \
  -p 8888:8888 \
  hangouts-planner/config-service:latest
```