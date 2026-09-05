package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer peopleId;
    String  name;
    String  number;
    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    List<BankName> bankName;

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public List<BankName> getBankName() {
        return bankName;
    }

    public void setBankName(List<BankName> bankName) {
        this.bankName = bankName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
