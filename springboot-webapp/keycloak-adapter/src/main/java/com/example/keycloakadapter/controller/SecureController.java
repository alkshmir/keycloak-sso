package com.example.keycloakadapter.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("secure")
public class SecureController {
    @GetMapping("hello")
    public String hello() {
        return "Hello Secure Application!!";
    }

    @GetMapping("user")
    public Object user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> results = new LinkedHashMap<>();

        Principal principal = (Principal) authentication.getPrincipal();

        if (principal != null) {
            results.put("principal-type", principal.getClass().getName());
            results.put("principal-name", principal.getName());
        }

        KeycloakSecurityContext context =
                ((KeycloakPrincipal) principal).getKeycloakSecurityContext();
        if (context != null) {
            results.put("id-token", context.getIdToken());
            results.put("roles", context.getToken().getRealmAccess().getRoles());
        }

        return results;
    }
}