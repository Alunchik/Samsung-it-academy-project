package com.example.samsung_project.model;

import java.util.ArrayList;

public class Test {
    private String id;

    public Test(String name) {
        this.name = name;
        this.questions = new ArrayList<Question>();
    }

    private String name;
    private String description;
    private  ArrayList<Question> questions;
    public static Test currentTest;
    public static ArrayList<Test> existingTests = generateTests();

    private static ArrayList<Test> generateTests(){
        String[] names ={"Russian language test", "Student stress level", "Your opinion about clothing brands"};
        ArrayList<Test> tests = new ArrayList<Test>();
        for(int i=0; i< names.length; i++) {
            Test test = new Test(names[i]);
            tests.add(test);
        }
        return tests;
    }


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
