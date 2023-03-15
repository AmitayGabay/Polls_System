package com.example.polls_system.service;

import com.example.polls_system.model.Answer;
import com.example.polls_system.model.Question;

public interface PollServiceInterface {
    String createQuestion(Question question);

    Question getQuestionById(Integer id);

    String updateQuestion(Question question);

    String deleteQuestionById(Integer id);

    String getAllQuestions();

    String answerTheQuestion(Answer answer);

    String deleteAnswersByUserId(Integer id);

    Integer getNumberOfAnswersToQuestion(Integer id);

    Integer getNumberOfAnswersPerUser(Integer id);

    String getHowManyUsersChooseEachOfQuestionOptions(Integer id);

    String getUserAnswersToEachQuestionHeSubmitted(Integer id);
}
