package org.acedrin.nirdecaaccounting.domain;

public class User {
    private Long id;
    private String login;

    public User(Long id, String login, String familyName, String name) {
        this.id = id;
        this.login = login;
        this.familyName = familyName;
        this.name = name;
    }

    private String familyName;
    private String name;

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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
