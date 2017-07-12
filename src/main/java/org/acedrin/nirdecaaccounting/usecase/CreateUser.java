package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {

    private final UserRepository userRepository;

    @Autowired
    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        user.prepareToSave();
        return userRepository.save(user);
    }
}
