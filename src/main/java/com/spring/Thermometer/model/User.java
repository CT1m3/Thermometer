package com.spring.Thermometer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String username;
    @Column(name = "password")
    private String password;
    @Transient
    @Column(name = "confirm_password")
    private String cnfPassword;
    @Column(name = "role")
    private String role;

    public User() {
    }
    public User(String username, String password, String cnfPassword, String role) {
        this.username = username;
        this.password = password;
        this.cnfPassword = cnfPassword;
        this.role = role;
    }

    public User(int id, String username, String password, String cnfPassword, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cnfPassword = cnfPassword;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnfPassword() {
        return cnfPassword;
    }

    public void setCnfPassword(String cnfPassword) {
        this.cnfPassword = cnfPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
