package com.example.polls_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private Integer id;
    private String title;
    @JsonProperty(value = "first_answer")
    private String firstAnswer;
    @JsonProperty(value = "second_answer")
    private String secondAnswer;
    @JsonProperty(value = "third_answer")
    private String thirdAnswer;
    @JsonProperty(value = "fourth_answer")
    private String fourthAnswer;

    public Question(Integer id, String title, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer) {
        this.id = id;
        this.title = title;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public String getFourthAnswer() {
        return fourthAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }

    @Override
    public String toString() {
        return "Question number " + this.getId() + ":" + '\n' +
                "title = " + title + '\n' +
                "first answer = " + firstAnswer + '\n' +
                "second answer = " + secondAnswer + '\n' +
                "third answer = " + thirdAnswer + '\n' +
                "fourth answer = " + fourthAnswer + '\n';
    }
}
