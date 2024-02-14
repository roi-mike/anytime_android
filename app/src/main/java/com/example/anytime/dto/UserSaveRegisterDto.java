package com.example.anytime.dto;

public class UserSaveRegisterDto {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String confpassword;
    private String first_language;
    private String date_incription;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getConfpassword() {
        return confpassword;
    }

    public void setConfpassword(String confpassword) {
        this.confpassword = confpassword;
    }

    public String getFirst_language() {
        return first_language;
    }

    public void setFirst_language(String first_language) {
        this.first_language = first_language;
    }

    public String getDate_incription() {
        return date_incription;
    }

    public void setDate_incription(String date_incription) {
        this.date_incription = date_incription;
    }

    public String getDate_desincription() {
        return date_desincription;
    }

    public void setDate_desincription(String date_desincription) {
        this.date_desincription = date_desincription;
    }

    private String date_desincription;


    public UserSaveRegisterDto(String first_name, String last_name, String email, String password, String confpassword, String first_language, String date_incription, String date_desincription) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.confpassword = confpassword;
        this.first_language = first_language;
        this.date_incription = date_incription;
        this.date_desincription = date_desincription;
    }
}
