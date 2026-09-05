package org.example.entity;

import jakarta.persistence.*;

@Entity
public class BankName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer BankId;
    String  bankName;
    String  ifscCode;
    String  adddress;
    @ManyToOne
    @JoinColumn(name = "peopleId")
    People people;

    public Integer getBankId() {
        return BankId;
    }

    public void setBankId(Integer bankId) {
        BankId = bankId;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
