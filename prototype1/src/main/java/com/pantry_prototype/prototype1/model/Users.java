package com.pantry_prototype.prototype1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column
    private String Name;

    @Column
    private String password;

    public Integer getUserID() {
        return userID;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users [userID=" + userID + ", Name=" + Name + ", password=" + password + "]";
    }
    
}
