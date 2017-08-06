package org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms;

import org.acedrin.nirdecaaccounting.domain.User;

public class CreateUserForm {

    public String login;
    public String firstName;
    public String lastName;

    public User toUser() {
        return new User(login, firstName, lastName);
    }
}
