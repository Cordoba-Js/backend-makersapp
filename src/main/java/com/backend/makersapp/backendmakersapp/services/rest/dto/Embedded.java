package com.backend.makersapp.backendmakersapp.services.rest.dto;

import java.util.List;

public class Embedded {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
