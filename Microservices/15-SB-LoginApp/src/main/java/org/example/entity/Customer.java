package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cname;
    private String cpwd;
    private Long  cphone;

    public Integer getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getCpwd() {
        return cpwd;
    }

    public Long getCphone() {
        return cphone;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    public void setCphone(Long cphone) {
        this.cphone = cphone;
    }
}
