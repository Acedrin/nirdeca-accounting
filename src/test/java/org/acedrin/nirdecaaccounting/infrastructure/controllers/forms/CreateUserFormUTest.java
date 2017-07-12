package org.acedrin.nirdecaaccounting.infrastructure.controllers.forms;

import org.acedrin.nirdecaaccounting.domain.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserFormUTest {

    private static final String LOGIN = "user@example.org";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Test
    public void toUser_shouldConvertFormToUser() throws Exception {
        // Given
        CreateUserForm createUserForm = new CreateUserForm();
        createUserForm.login= LOGIN;
        createUserForm.firstName= FIRST_NAME;
        createUserForm.lastName= LAST_NAME;

        // When
        User user = createUserForm.toUser();

        // Then
        assertThat(user.getLogin()).isEqualTo(LOGIN);
        assertThat(user.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(user.getLastName()).isEqualTo(LAST_NAME);
    }
}