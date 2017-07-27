package org.acedrin.nirdecaaccounting.infrastructure.controllers;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.infrastructure.controllers.forms.CreateUserForm;
import org.acedrin.nirdecaaccounting.usecase.CreateUser;
import org.acedrin.nirdecaaccounting.usecase.GetAllUsers;
import org.acedrin.nirdecaaccounting.usecase.GetUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserEndpointUTest {

    private static final long USER_ID = 1L;

    @Mock
    private CreateUser createUser;

    @Mock
    private GetAllUsers getAllUsers;

    @Mock
    private GetUser getUser;

    private CreateUserForm createUserForm;
    private UserEndpoint userEndpoint;

    @Before
    public void setUp() {
        userEndpoint = new UserEndpoint(createUser, getAllUsers, getUser);
        createUserForm = new CreateUserForm();
    }

    @Test
    public void createUser_shouldReturnSavedUser() throws Exception {
        // Given
        User expectedSavedUser = new User();
        when(createUser.create(any(User.class))).thenReturn(expectedSavedUser);

        // When
        User result = userEndpoint.createUser(createUserForm);

        // Then
        assertThat(result).isSameAs(expectedSavedUser);
    }

    @Test
    public void getAllUsers_shouldReturnAllUsers() throws Exception {
        // Given
        List<User> users = new ArrayList<>();
        when(getAllUsers.findAllUsers()).thenReturn(users);

        // When
        List<User> result = userEndpoint.getAllUsers();

        // Then
        assertThat(result).isSameAs(users);
    }

    @Test
    public void getUser_shouldAUser() throws Exception {
        // Given
        User user = new User();
        Long userId = USER_ID;
        when(getUser.findUser(userId)).thenReturn(user);

        // When
        User result = userEndpoint.getUser(USER_ID);

        // Then
        assertThat(result).isSameAs(user);
    }
}