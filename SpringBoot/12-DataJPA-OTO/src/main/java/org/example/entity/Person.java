package org.example.entity;

import jakarta.persistence.*;
import org.example.generator.PersonGen;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @PersonGen
    String personId;
    String name;
    String email;
    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    Passport passport;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passport=" + passport +
                '}';
    }
}
