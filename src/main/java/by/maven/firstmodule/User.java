package by.maven.firstmodule;

import java.io.Serializable;

public class User implements Serializable {

        private final Long id;
        private final String login;
        private final String firstName;
        private final String lastName;
        private final String password;
        private final String role;


    User(Long Id, String Login, String fName, String lName, String pass, String Role){
        this.id = Id;
        this.login = Login;
        this.firstName = fName;
        this.lastName = lName;
        this.password = pass;
        this.role = Role;
    }

Long getId(){
    return id;
}
String getLogin() {return login;}

//    @Override
//    public String toString(){
//        return this.id + " " + this.login + " " + this.firstName+ " " + this.lastName+ " "+  this.password+ " " +  this.role + ";";
//    }
}
