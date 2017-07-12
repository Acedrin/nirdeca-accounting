package org.acedrin.nirdecaaccounting.infrastructure.controllers;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.infrastructure.controllers.forms.CreateUserForm;
import org.acedrin.nirdecaaccounting.usecase.CreateUser;
import org.acedrin.nirdecaaccounting.usecase.GetAllUsers;
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

    private static final String LOGIN = "user@example.org";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "LastName";

    @Mock
    private GetAllUsers getAllUsers;

    @Mock
    private CreateUser createUser;

    private CreateUserForm createUserForm;
    private UserEndpoint userEndpoint;

    @Before
    public void setUp() {
        userEndpoint = new UserEndpoint(createUser, getAllUsers);
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
}