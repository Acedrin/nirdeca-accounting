package org.acedrin.nirdecaaccounting.domain;

public class User {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    public User() {
    }

    public User(String login, String familyName, String name) {
        this.login = login;
        this.firstName = familyName;
        this.lastName = name;
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
