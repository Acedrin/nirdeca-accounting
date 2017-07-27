package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUser {

    private final UserRepository userRepository;

    @Autowired
    public GetUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(Long userId) {
        return userRepository.findById(userId);
    }
}
