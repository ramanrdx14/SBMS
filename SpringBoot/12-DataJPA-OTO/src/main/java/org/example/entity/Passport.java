package org.example.entity;

import jakarta.persistence.*;
import org.example.generator.PassportGen;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @PassportGen
    String passportId;
    String passportNo;
    @OneToOne
    @JoinColumn(name = "personId")
    Person person;
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }
}
