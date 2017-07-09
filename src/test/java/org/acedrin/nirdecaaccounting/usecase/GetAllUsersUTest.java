package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetAllUsersUTest {
    @Mock
    private UserRepository userRepository;

    private GetAllUsers getAllUsers;

    @Before
    public void setUp() throws Exception {
        getAllUsers = new GetAllUsers(userRepository);
    }

    @Test
    public void findAllUsers_shouldReturnAllUsers() throws Exception {
        // Given
        List<User> users = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(users);

        // When
        List<User> result = getAllUsers.findAllUsers();

        // Then
        assertThat(result).isSameAs(users);
    }
}