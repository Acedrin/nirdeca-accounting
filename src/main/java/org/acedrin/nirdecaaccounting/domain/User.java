package org.acedrin.nirdecaaccounting.domain;

public class User {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    public User() {
    }

    public User(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void prepareToSave() {
        validate();
    }

    private void validate() {
        if (login == null) {
            throw new InvalidUserException("Missing login");
        }
        if (firstName == null) {
            throw new InvalidUserException("Missing firstName");
        }
        if (lastName == null) {
            throw new InvalidUserException("Missing lastName");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
