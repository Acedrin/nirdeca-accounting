package org.acedrin.nirdecaaccounting.infrastructure.controllers;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.infrastructure.controllers.forms.CreateUserForm;
import org.acedrin.nirdecaaccounting.usecase.CreateUser;
import org.acedrin.nirdecaaccounting.usecase.GetAllUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserEndpoint {
    private final CreateUser createUser;
    private final GetAllUsers getAllUsers;

    @Autowired
    public UserEndpoint(CreateUser createUser, GetAllUsers getAllUsers) {
        this.createUser = createUser;
        this.getAllUsers = getAllUsers;
    }

    @PostMapping(value = "/api/users", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody CreateUserForm createUserForm) {
        return createUser.create(createUserForm.toUser());
    }

    @RequestMapping(value = "/api/users", produces = "application/json")
    public List<User> getAllUsers() {
        return getAllUsers.findAllUsers();
    }
}
