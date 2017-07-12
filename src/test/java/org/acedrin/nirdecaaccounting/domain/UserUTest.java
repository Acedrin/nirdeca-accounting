package org.acedrin.nirdecaaccounting.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class UserUTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("user@example.org", "firstName", "lastName");
    }

    @Test
    public void prepareToSave_shouldThrowInvalidUserException_whenLoginIsNull() throws Exception {
        // Given
        user.setLogin(null);

        // When
        Throwable throwable = catchThrowable(() -> user.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidUserException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing login");
    }

    @Test
    public void prepareToSave_shouldThrowInvalidUserException_whenFirstNameIsNull() throws Exception {
        // Given
        user.setFirstName(null);

        // When
        Throwable throwable = catchThrowable(() -> user.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidUserException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing firstName");
    }

    @Test
    public void prepareToSave_shouldThrowInvalidUserException_whenLastNameIsNull() throws Exception {
        // Given
        user.setLastName(null);

        // When
        Throwable throwable = catchThrowable(() -> user.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidUserException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing lastName");
    }
}