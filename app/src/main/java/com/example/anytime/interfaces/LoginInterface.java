package com.example.anytime.interfaces;

public class LoginInterface {

    private String email;
    private String password;


    public LoginInterface(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Boolean validateloginconnection(LoginInterface loginInterface){
        if (loginInterface.getEmail() != null && !loginInterface.getEmail().isEmpty() &&
                loginInterface.getPassword() != null && !loginInterface.getPassword().isEmpty()
        ){
            return true;
        }

        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
