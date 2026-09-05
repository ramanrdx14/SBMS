package org.example.bindings;
public class Student {
    String stdId;
    String stdName;
    String stdRoll;

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdRoll() {
        return stdRoll;
    }

    public void setStdRoll(String stdRoll) {
        this.stdRoll = stdRoll;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdId='" + stdId + '\'' +
                ", stdName='" + stdName + '\'' +
                ", stdRoll='" + stdRoll + '\'' +
                '}';
    }
}
