package org.acedrin.nirdecaaccounting.infrastructure.controllers;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.usecase.GetAllUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEndpoint {
    private final GetAllUsers getAllUsers;

    @Autowired
    public UserEndpoint(GetAllUsers getAllUsers) {
        this.getAllUsers = getAllUsers;
    }

    @RequestMapping(value = "/api/users", produces = "application/json")
    public List<User> getAllUsers() {
        return getAllUsers.findAllUsers();
    }
}
