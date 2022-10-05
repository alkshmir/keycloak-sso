# Spring boot Keycloak adapter sample


## Usage
Before running adapter, run [Keycloak](../../keycloak/README.md) and configure realm, client, and users.

1. if you have not created docker network, create one:
   ```
   docker network create sample-nw
   ```
1. replace `CLIENT_SECRET` in `docker-compose.yml`
1. build and run
   ```
   # this may take minutes
   docker build -t keycloak-adapter .
   # run
   docker compose up -d
   ```