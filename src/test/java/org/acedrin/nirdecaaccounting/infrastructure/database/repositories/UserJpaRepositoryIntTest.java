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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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
    public void save_shouldPersistUser_wuthAutoIncrementedId() throws Exception {
        // Given
        User firstPersist = userRepository.save(user);
        User secondUser = new User("user@example.org", "firstName", "lastName");

        // When
        User secondPersit = userRepository.save(secondUser);

        // Then
        assertThat(secondPersit.getId()).isEqualTo(firstPersist.getId() + 1);
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenLoginIsNull() {
        // Given
        user.setLogin(null);

        // When
        Throwable throwable = catchThrowable(() -> userRepository.save(user));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("login");
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenFirstNameIsNull() {
        // Given
        user.setFirstName(null);

        // When
        Throwable throwable = catchThrowable(() -> userRepository.save(user));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("first_name");
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenLastNameIsNull() {
        // Given
        user.setLastName(null);

        // When
        Throwable throwable = catchThrowable(() -> userRepository.save(user));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("last_name");
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