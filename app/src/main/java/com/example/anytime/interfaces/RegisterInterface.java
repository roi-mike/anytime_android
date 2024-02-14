package com.example.anytime.interfaces;

public class RegisterInterface {
    private String first_name;
    private  String last_name;
    private  String email;
    private  String password;

    public RegisterInterface(String f_nametxt, String l_nametxt, String emailtxt, String passwordtxt){
        this.first_name = f_nametxt;
        this.last_name = l_nametxt;
        this.email = emailtxt;
        this.password = passwordtxt;
    }

    public  boolean validateRegister(RegisterInterface registerInterface){
        if (registerInterface.getF_nametxt() != null && !registerInterface.getF_nametxt().isEmpty() &&
                registerInterface.getL_nametxt() != null && !registerInterface.getL_nametxt().isEmpty() &&
                registerInterface.getEmailtxt() != null && !registerInterface.getEmailtxt().isEmpty() &&
                registerInterface.getPasswordtxt() != null && !registerInterface.getPasswordtxt().isEmpty()
        ){
            return true;
        }

        return false;
    }

    public String getF_nametxt(){
        return first_name;
    }

    public void setF_name(String f_nametxt){
        this.first_name = f_nametxt;
    }

    public  String getL_nametxt(){
        return last_name;
    }
    public void setL_nametxt(String l_nametxt){
        this.last_name = l_nametxt;
    }
    public String getEmailtxt(){
        return email;
    }
    public void setEmailtxt(String emailtxt){
        this.email = emailtxt;
    }
    public String getPasswordtxt(){
        return password;
    }
    public void setPasswordtxt(String passwordtxt){
        this.password = passwordtxt;
    }
}
