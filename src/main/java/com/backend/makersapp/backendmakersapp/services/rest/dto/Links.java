package com.backend.makersapp.backendmakersapp.services.rest.dto;

public class Links {
    private Link self;
    private Link student;

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Link getStudent() {
        return student;
    }

    public void setStudent(Link student) {
        this.student = student;
    }
}
