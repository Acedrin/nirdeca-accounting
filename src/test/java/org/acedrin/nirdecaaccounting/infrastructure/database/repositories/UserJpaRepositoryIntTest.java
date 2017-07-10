package org.acedrin.nirdecaaccounting.infrastructure.database.repositories;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.domain.UserRepository;
import org.acedrin.nirdecaaccounting.infrastructure.database.MappingsConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(MappingsConfiguration.class)
public class UserJpaRepositoryIntTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("john.doe@example.org", "John", "Doe");
    }

    @Test
    public void findAll_shouldReturnAllUsers() throws Exception {
        // Given
        testEntityManager.persist(user);

        // When
        List<User> result = userRepository.findAll();

        // Then
        assertThat(result).containsExactly(user);
    }
}