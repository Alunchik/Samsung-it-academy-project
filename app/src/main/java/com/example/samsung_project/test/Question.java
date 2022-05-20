package com.example.samsung_project.test;

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
}
