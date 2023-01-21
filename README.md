# Hangouts Planner

This is a monorepo for **Hangouts Planner** applications - both frontend and backend ones.

## Docker

### Useful images (outside of project's scope)

#### pgadmin

```shell
docker run \
  -d \
  -p 80:80 \
  -e 'PGADMIN_DEFAULT_EMAIL=user@domain.com' \
  -e 'PGADMIN_DEFAULT_PASSWORD=postgres' \
  -v pg-admin-data:/var/lib/pgadmin \
  --name pgadmin4 \
  dpage/pgadmin4
```

## Links
https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#container-images   
https://springdoc.org/faq.html#how-can-i-deploy-springdoc-openapi-ui-behind-a-reverse-proxy