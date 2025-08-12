package com.backend.bybus.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private User user;
    private String name;
    private String contactNumber;
    private String email;
    
    public Passenger(String name, String contactNumber, String email) {
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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                '}';    
    }
    
}
