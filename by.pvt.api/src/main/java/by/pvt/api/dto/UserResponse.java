package by.pvt.api.dto;

public class UserResponse {
    private long id;
    private String firstName;
    private String surName;
    private String full_name;
    private String login;
    private String email;
    private String role;
    private long phone;

    public UserResponse(){}
    public UserResponse (long Id, String firstname, String surname, String fullname, String login, String eMail, String role){
        this.id = Id; this.firstName = firstname; this.surName = surname;
        this.full_name = fullname; this.login = login; this.role = role;this.email = eMail;
    }

    public void setId(Long iD) {this.id = iD;}
    public void setFirstName(String fname){this.firstName = fname;}
    public void setSurName(String sname){this.surName = sname;}
    public void setFull_name(String fullname){this.full_name = fullname;}
    public void setLogin(String logIn){this.login = logIn;}
    public void setEmail(String eMail){this.email = eMail;}
    public void setPhone(long pHone){this.phone = pHone;}
    public void setRole(String r){this.role = r;}

    public long getId(){return this.id;}
    public String getFirstName(){return this.firstName;}
    public String getSurName(){return this.surName;}
    public String getFull_name(){return this.full_name;}
    public String getLogin(){return this.login;}
    public String getEmail(){return this.email;}
    public long getPhone(){return this.phone;}
    public String getRole(){return this.role; }
}
