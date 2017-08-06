package org.acedrin.nirdecaaccounting.infrastructure.endpoints;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms.CreateUserForm;
import org.acedrin.nirdecaaccounting.usecase.CreateUser;
import org.acedrin.nirdecaaccounting.usecase.GetAllUsers;
import org.acedrin.nirdecaaccounting.usecase.GetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserEndpoint {
    private final CreateUser createUser;
    private final GetAllUsers getAllUsers;
    private final GetUser getUser;

    @Autowired
    public UserEndpoint(CreateUser createUser, GetAllUsers getAllUsers, GetUser getUser) {
        this.createUser = createUser;
        this.getAllUsers = getAllUsers;
        this.getUser = getUser;
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

    @RequestMapping(value = "/api/users/{userId}", produces = "application/json")
    public User getUser(@PathVariable("userId") Long userId) {
        return getUser.findUser(userId);
    }
}
