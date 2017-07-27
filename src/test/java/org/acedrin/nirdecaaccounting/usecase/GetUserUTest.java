package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.User;
import org.acedrin.nirdecaaccounting.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetUserUTest {

    private static final long USER_ID = 1L;

    @Mock
    private UserRepository userRepository;

    private GetUser getUser;

    @Before
    public void setUp() throws Exception {
        getUser = new GetUser(userRepository);
    }

    @Test
    public void findUser_shouldReturnExpectedUser() throws Exception {
        // Given
        User user = new User();
        when(userRepository.findById(USER_ID)).thenReturn(user);

        // When
        User result = getUser.findUser(USER_ID);

        // Then
        assertThat(result).isSameAs(user);
    }
}