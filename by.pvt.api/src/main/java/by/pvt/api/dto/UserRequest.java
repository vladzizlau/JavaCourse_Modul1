package by.pvt.api.dto;

public class UserRequest {
    private long id;
    private String login;
    private String firstName;
    private String surName;
    private String password;
    private String email;
    private long phone;
    private String role;



public UserRequest(){}

    public UserRequest(long id, String login, String firstName, String surName, String password, String email, long phone, String role) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.surName = surName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }
}
