package org.acedrin.nirdecaaccounting.infrastructure.controllers;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.usecase.CreateUser;
import org.acedrin.nirdecaaccounting.usecase.GetAllUsers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserEndpoint.class)
public class UserEndpointIntTest {

    private static final long ID = 1L;
    private static String LOGIN = "user@example.org";
    private static String FIRST_NAME = "firstName";
    private static String LAST_NAME = "lastName";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateUser createUser;

    @MockBean
    private GetAllUsers getAllUsers;

    @Test
    public void post_onUsersEndpoint_shouldReturnCreatedUser_asJson() throws Exception {
        // Given
        User user = new User(LOGIN, FIRST_NAME, LAST_NAME);
        user.setId(ID);
        when(createUser.create(any(User.class))).thenReturn(user);

        // When
        ResultActions resultActions = mockMvc.perform(post("/api/users")
                .contentType(APPLICATION_JSON)
                .content("{\"login\":\"" + LOGIN + "\"," +
                        "\"firstName\":\"" + FIRST_NAME + "\"," +
                        "\"lastName\":\"" + LAST_NAME + "\"}"));

        // Then
        resultActions.andExpect(status().isCreated())
                .andExpect(content().string("{\"id\":" + ID + "," +
                        "\"login\":\"" + LOGIN + "\"," +
                        "\"firstName\":\"" + FIRST_NAME + "\"," +
                        "\"lastName\":\"" + LAST_NAME + "\"" +
                        "}"));
    }

    @Test
    public void get_onUsersEndpoint_shouldReturnAllUsers() throws Exception {
        // Given
        List<User> userList = asList(new User(), new User());
        when(getAllUsers.findAllUsers()).thenReturn(userList);

        // When
        ResultActions resultActions = mockMvc.perform(get("/api/users"));

        // Then
        resultActions.andExpect(status().isOk())
                .andExpect(content().string("[" +
                        "{\"id\":null," +
                        "\"login\":null," +
                        "\"firstName\":null," +
                        "\"lastName\":null}," +
                        "{\"id\":null," +
                        "\"login\":null," +
                        "\"firstName\":null," +
                        "\"lastName\":null" +
                        "}]"));
    }
}