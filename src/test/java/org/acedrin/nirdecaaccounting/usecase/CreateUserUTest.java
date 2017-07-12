package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserUTest {

    @Mock
    private UserRepository userRepository;

    private CreateUser createUser;
    private User user;

    @Before
    public void setUp() throws Exception {
        createUser = new CreateUser(userRepository);
        user = new User("user@example.org", "firstName", "lastName");
    }

    @Test
    public void create_shouldPrepareToSaveUser() throws Exception {
        // Given
        user = mock(User.class);

        // When
        createUser.create(user);

        // Then
        verify(user).prepareToSave();
    }

    @Test
    public void create_shouldSaveUser() throws Exception {
        // When
        createUser.create(user);

        // Then
        verify(userRepository).save(user);
    }

    @Test
    public void create_shouldReturnSavedUser() throws Exception {
        // Given
        User expectedUser = new User();
        when(userRepository.save(user)).thenReturn(expectedUser);

        // When
        User savedUser = createUser.create(user);

        // Then
        assertThat(savedUser).isSameAs(expectedUser);
    }
}