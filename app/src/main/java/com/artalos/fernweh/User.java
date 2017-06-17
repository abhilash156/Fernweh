package com.artalos.fernweh;

/**
 * Created by Abhilash on 17-06-2017.
 */

public class User {

    private Integer userID;
    private String userName;
    private String userEmail;
    private String userContact;
    private String userCity;
    private String userBudgetMin;
    private String userBudgetMax;
    private String userBio;
    private String userInterests;


    public User(Integer userID, String userName, String userEmail, String userContact, String userCity, String userBudgetMin, String userBudgetMax, String userBio, String userInterests) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userContact = userContact;
        this.userCity = userCity;
        this.userBudgetMin = userBudgetMin;
        this.userBudgetMax = userBudgetMax;
        this.userBio = userBio;
        this.userInterests = userInterests;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserBudgetMin() {
        return userBudgetMin;
    }

    public void setUserBudgetMin(String userBudgetMin) {
        this.userBudgetMin = userBudgetMin;
    }

    public String getUserBudgetMax() {
        return userBudgetMax;
    }

    public void setUserBudgetMax(String userBudgetMax) {
        this.userBudgetMax = userBudgetMax;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public String getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(String userInterests) {
        this.userInterests = userInterests;
    }
}
