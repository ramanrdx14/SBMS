package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    String userName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="user_roles",
        joinColumns = {
                @JoinColumn(name="userId")
        },
        inverseJoinColumns = {
                @JoinColumn(name="role_id")
        }
    )
    List<Roles> roles;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
