package by.pvt.api.dto;

public class UserRequest {
    private String login;
    private String firstName;
    private String surName;
    private String password;
    private String email;
    private String phone;



public UserRequest(){}
    public UserRequest(String login, String name, String surname, String pass, String emAil, String pHone){this.login = login; this.firstName = name; this.surName = surname; this.password = pass; this.email = emAil; this.phone = pHone;}
    public String getLogin(){return login;}
    public String getFirstName(){return firstName;}
    public String getSurName(){return surName;}
    public String getPassword(){return password;}
    public String getEmail(){return email;}
    public String getPhone(){return phone;}

//    public void setLogin(String login){this.login = login;}
//    public void setFirstName(String name){this.firstName = name;}
//    public void setSurName(String sname){this.surName = sname;}
//    public void setPassword(String pass){this.password = pass;}



}
