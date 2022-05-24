package com.example.samsung_project.model;

import java.util.ArrayList;

public class Question {

    public static Question getCurrentQuestion() {
        return CurrentQuestion;
    }

    public static void setCurrentQuestion(Question currentQuestion) {
        CurrentQuestion = currentQuestion;
    }

    public static Question CurrentQuestion;

    private String test_id;
    private int type;
    private String question;
    private ArrayList<Answer> answers;
    private int id;

    public Question(){

    }

    public Question(String test_id, String question, ArrayList<Answer> answers, int id) {
        this.test_id = test_id;
        this.type = type;
        this.question = question;
        this.answers = answers;
        this.id = id;
    }

    public void addAnswer(String text, Boolean correct){
        Answer answer = new Answer(text, correct);
        answers.add(answer);
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
