package org.acedrin.nirdecaaccounting.infrastructure.database.repositories;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserJpaRepository implements UserRepository {

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1L, "john@doe.1", "Doe1", "John1");
        User user2 = new User(2L, "john@doe.2", "Doe2", "John2");
        users.add(user1);
        users.add(user2);
        return users;
    }
}
