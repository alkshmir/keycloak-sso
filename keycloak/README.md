# keycloak setting for SSO

## run
```
docker compose up
```

## configure for SSO
1. connect to `localhost:8080/auth` and login
1. create realm named `demo-realm`
    - set frontend URL to `http://localhost:8080/auth`
1. create client named `demo-app`
    - set access type to `confidential`
    - set valid redirect URLs to `http://localhost:8088*`
    - press save button
    - copy client secret on `credentials` tab to springboot sample configuration
1. create realm role named `users`
1. create some user and assign `users` role
