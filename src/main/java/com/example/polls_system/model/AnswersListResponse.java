package com.example.polls_system.model;

import java.util.List;

public class AnswersListResponse {
    private List<Answer> answersList;

    public AnswersListResponse() {
    }

    public AnswersListResponse(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public Integer getSize() {
        return answersList.size();
    }

    public String toQuestionOptions() {
        int counterOfFirstOption = 0;
        int counterOfSecondOption = 0;
        int counterOfThirdOption = 0;
        int counterOfFourthOption = 0;
        for (int i = 0; i < answersList.size(); i++) {
            if (answersList.get(i).getAnswerNumber() == 1) {
                counterOfFirstOption++;
            }
            if (answersList.get(i).getAnswerNumber() == 2) {
                counterOfSecondOption++;
            }
            if (answersList.get(i).getAnswerNumber() == 3) {
                counterOfThirdOption++;
            }
            if (answersList.get(i).getAnswerNumber() == 4) {
                counterOfFourthOption++;
            }
        }
        return "The number of users who chose the first option of question number " + this.answersList.get(0).getQuestionId() + " is " + counterOfFirstOption + ".\n" +
                "The number of users who chose the second option of question number " + this.answersList.get(0).getQuestionId() + " is " + counterOfSecondOption + ".\n" +
                "The number of users who chose the third option of question number " + this.answersList.get(0).getQuestionId() + " is " + counterOfThirdOption + ".\n" +
                "The number of users who chose the fourth option of question number " + this.answersList.get(0).getQuestionId() + " is " + counterOfFourthOption + ".\n";
    }

    @Override
    public String toString() {
        String result = "The user's answers are: \n";
        for (int i = 0; i < answersList.size(); i++) {
            result += answersList.get(i).toString() + "\n";
        }
        return result;
    }
}
