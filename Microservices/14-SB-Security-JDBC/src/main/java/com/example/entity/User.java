package com.example.entity;

import jakarta.persistence.*;

import java.util.List;
import com.example.entity.Roles;
@Entity
@Table(name = "users")
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String userPassword;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
            @JoinTable(
                    name = "user_roles",
                    joinColumns = {
                            @JoinColumn(name = "user_id")
                    },
                    inverseJoinColumns = {
                            @JoinColumn(name = "role_id")
                    }
            )
    private List<Roles> roles;
    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}