package com.example.polls_system.repository;

import com.example.polls_system.model.Answer;
import com.example.polls_system.model.Question;

public interface PollRepositoryInterface {
    String createQuestion(Question question);

    Question getQuestionById(Integer id);

    String updateQuestion(Question question);

    String deleteQuestionById(Integer id);

    String getAllQuestions();

    String answerTheQuestion(Answer answer);

    String deleteAnswersByUserId(Integer id);

    Integer getNumberOfAnswersToQuestion(Integer id);

    Integer isUserAnswerTheQuestion(Integer questionId, Integer userId);

    Integer getNumberOfAnswersPerUser(Integer id);

    String getHowManyUsersChooseEachOfQuestionOptions(Integer id);

    String getUserAnswersToEachQuestionHeSubmitted(Integer id);
}
