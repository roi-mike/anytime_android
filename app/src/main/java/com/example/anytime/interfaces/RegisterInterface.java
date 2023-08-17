package com.example.anytime.interfaces;

public class RegisterInterface {
    private String f_nametxt;
    private  String l_nametxt;
    private  String emailtxt;
    private  String passwordtxt;
    private String confpasswordtxt;

    public RegisterInterface(String f_nametxt, String l_nametxt, String emailtxt, String passwordtxt, String confpasswordtxt){
        this.f_nametxt = f_nametxt;
        this.l_nametxt = l_nametxt;
        this.emailtxt = emailtxt;
        this.passwordtxt = passwordtxt;
        this.confpasswordtxt = confpasswordtxt;
    }

    public  boolean validateRegister(RegisterInterface registerInterface){
        if (registerInterface.getF_nametxt() != null && !registerInterface.getF_nametxt().isEmpty() &&
                registerInterface.getL_nametxt() != null && !registerInterface.getL_nametxt().isEmpty() &&
                registerInterface.getEmailtxt() != null && !registerInterface.getEmailtxt().isEmpty() &&
                registerInterface.getPasswordtxt() != null && !registerInterface.getPasswordtxt().isEmpty() &&
                registerInterface.getConfpasswordtxt() != null && ! registerInterface.getConfpasswordtxt().isEmpty()
        ){
            return true;
        }

        return false;
    }

    public String getF_nametxt(){
        return f_nametxt;
    }

    public void setF_name(String f_nametxt){
        this.f_nametxt = f_nametxt;
    }

    public  String getL_nametxt(){
        return l_nametxt;
    }
    public void setL_nametxt(String l_nametxt){
        this.l_nametxt = l_nametxt;
    }
    public String getEmailtxt(){
        return emailtxt;
    }
    public void setEmailtxt(String emailtxt){
        this.emailtxt = emailtxt;
    }
    public String getPasswordtxt(){
        return passwordtxt;
    }
    public void setPasswordtxt(String passwordtxt){
        this.passwordtxt = passwordtxt;
    }
    public String getConfpasswordtxt(){
        return confpasswordtxt;
    }
    public void setConfpasswordtxt(String confpasswordtxt){
        this.confpasswordtxt = confpasswordtxt;
    }
}
