package com.backend.bybus.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.bybus.auth.services.AuthorizationService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.backend.bybus.auth.model.user.User;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/createUser")
    public User createOwner(@RequestBody User entity) {
        //entity.setId(UUID.randomUUID().toString());
        return authorizationService.createUser(entity);
    }
    


}
