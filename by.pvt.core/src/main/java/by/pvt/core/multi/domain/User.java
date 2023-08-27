package by.pvt.core.multi.domain;

import java.io.Serializable;

public class User implements Serializable {

    private long id;
    private String login;
    private String firstName;
    private String surName;
    private String fullName;
    private long phoneNumber;
    private String email;
    private String adress;
    private String password;
    private String role;


    public User(Long Id, String Login, String fName, String sName, long phone, String email, String pass, String Role) {
        this.id = Id;
        this.login = Login;
        this.firstName = fName;
        this.surName = sName;
        this.fullName = fName + sName;
        this.phoneNumber = phone;
        this.email = email;
        this.password = pass;
        this.role = Role;
    }

    public User() {

    }

    public Long getId(){return id; }
    public String getLogin(){return login;}
    public String getFirstName(){return firstName;}
    public String getSurName(){return surName;}
    public String getFullName(){return firstName + " " + surName;}
    public long  getPhoneNumber(){return phoneNumber;}
    public String getEmail(){return email;}
    public String getAdress(){return adress;}
    public String getPassword(){return password;}
    public String getRole(){return role;}

    public void setId(Long Id) {this.id = Id;}
    public void setLogin(String log){this.login = log;}
    public void setFirstName(String fname){this.firstName = fname;}
    public void setSurName(String sname){this.surName = sname;}
    public void setPhoneNumber(long number){this.phoneNumber = number;}
    public void setEmail(String email){this.email = email;}
    public void setAdress(String adress) {this.adress = adress;}
    public void setPassword(String pass) {this.password = pass;}
    public void setRole(String r){this.role = r;}

}
