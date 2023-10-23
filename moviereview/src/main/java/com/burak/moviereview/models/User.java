package com.burak.moviereview.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Users")
public class User {
    public User() {
    }

    public User(String id, String username, String password, String email, String profilePicture) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    public User(String username, String password, String email, String profilePicture) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String username;
    private String password;
    private String email;
    private String profilePicture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
