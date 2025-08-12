package com.backend.bybus.users.model;


public class Owner {

    private User user;
    private String name;
    private String contactNumber;
    private String email;
    
    public Owner(String name, String contactNumber, String email) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }
    public String getName() {
        return name;
    }  
    public String getContactNumber() {
        return contactNumber;
    }
    public String getEmail() {
        return email;
    }   
    public void setName(String name) {
        this.name = name;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;  
    }
    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                '}';    
    }
    



}