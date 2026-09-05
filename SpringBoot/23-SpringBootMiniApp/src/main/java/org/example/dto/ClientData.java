package org.example.dto;

import java.util.List;

public class ClientData {
    String email;
    String gender;
    List<Integer> coursesId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Integer> getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(List<Integer> coursesId) {
        this.coursesId = coursesId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
