package com.example.samsung_project.model;

import java.util.ArrayList;

public class Test {
    private String id;

    public Test(String id) {
        this.id = id;
        this.questions = new ArrayList<Question>();
    }

    private String name;
    private String description;
    private  ArrayList<Question> questions;
    public static Test currentTest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
