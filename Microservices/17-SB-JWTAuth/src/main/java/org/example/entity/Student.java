package org.example.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer stdId;
    String stdName;
    Integer stdRoll;
    String stdPwd;

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public Integer getStdRoll() {
        return stdRoll;
    }

    public void setStdRoll(Integer stdRoll) {
        this.stdRoll = stdRoll;
    }

    public String getStdPwd() {
        return stdPwd;
    }

    public void setStdPwd(String stdPwd) {
        this.stdPwd = stdPwd;
    }
}
