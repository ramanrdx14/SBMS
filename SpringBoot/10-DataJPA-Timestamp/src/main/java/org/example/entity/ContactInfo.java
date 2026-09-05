package org.example.entity;

import jakarta.persistence.*;
import org.example.customgen.GenericGenerator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "contact")
public class ContactInfo {
    @Id
    @GenericGenerator
    private String Id;
    private String  name;
    private String email;
    private String phoneNo;
    @CreationTimestamp
    @Column(name = "create_dt",updatable = false)
    private LocalDate createDt;
    @UpdateTimestamp
    @Column(name = "update_dt",insertable = false)
    private LocalDate updateDt;

    @Override
    public String toString() {
        return "ContactInfo{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", createDt=" + createDt +
                ", updateDt=" + updateDt +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getCreateDt() {
        return createDt;
    }

    public void setCreateDt(LocalDate createDt) {
        this.createDt = createDt;
    }

    public LocalDate getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(LocalDate updateDt) {
        this.updateDt = updateDt;
    }
}
