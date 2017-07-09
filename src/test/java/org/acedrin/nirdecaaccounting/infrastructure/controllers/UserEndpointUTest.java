package org.acedrin.nirdecaaccounting.infrastructure.controllers;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.usecase.GetAllUsers;
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
public class UserEndpointUTest {
    @Mock
    private GetAllUsers getAllUsers;

    private UserEndpoint userEndpoint;

    @Before
    public void setUp() {
        userEndpoint = new UserEndpoint(getAllUsers);
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