package org.acedrin.nirdecaaccounting.infra.controllers;

import org.acedrin.nirdecaaccounting.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        User user1 = new User(1L, "john@doe.1", "Doe1", "John1");
        User user2 = new User(2L, "john@doe.2", "Doe2", "John2");
        users.add(user1);
        users.add(user2);
        return users;
    }
}
