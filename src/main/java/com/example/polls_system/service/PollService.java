package com.example.polls_system.service;

import com.example.polls_system.model.Answer;
import com.example.polls_system.model.Question;
import com.example.polls_system.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollService implements PollServiceInterface {
    @Autowired
    private PollRepository pollRepository;

    @Override
    public String createQuestion(Question question) {
        if (question.getTitle() == null || question.getFirstAnswer() == null || question.getSecondAnswer() == null ||
                question.getThirdAnswer() == null || question.getFourthAnswer() == null) {
            return "Question not created, title, first answer, second answer, third answer and fourth answer are required";
        }
        return pollRepository.createQuestion(question);
    }

    @Override
    public Question getQuestionById(Integer id) {
        if (id == null) {
            System.out.println("It is not possible to accept the question without id");
            return null;
        }
        return pollRepository.getQuestionById(id);
    }

    @Override
    public String updateQuestion(Question question) {
        if (question.getId() == null) {
            return "Question not updated, id is required";
        }
        Question questionBeforeUpdate = pollRepository.getQuestionById(question.getId());
        if (questionBeforeUpdate == null) {
            return "The question with this id does not exist, so it cannot be updated";
        }
        if (question.getTitle() == null) {
            question.setTitle(questionBeforeUpdate.getTitle());
        }
        if (question.getFirstAnswer() == null) {
            question.setFirstAnswer(questionBeforeUpdate.getFirstAnswer());
        }
        if (question.getSecondAnswer() == null) {
            question.setSecondAnswer(questionBeforeUpdate.getSecondAnswer());
        }
        if (question.getThirdAnswer() == null) {
            question.setThirdAnswer(questionBeforeUpdate.getThirdAnswer());
        }
        if (question.getFourthAnswer() == null) {
            question.setFourthAnswer(questionBeforeUpdate.getFourthAnswer());
        }
        return pollRepository.updateQuestion(question);
    }

    @Override
    public String deleteQuestionById(Integer id) {
        if (id == null) {
            return "It is not possible to delete the question without id";
        }
        Question questionBeforeDelete = pollRepository.getQuestionById(id);
        if (questionBeforeDelete == null) {
            return "The question with this id does not exist, so it cannot be deleted";
        }
        return pollRepository.deleteQuestionById(id);
    }

    @Override
    public String getAllQuestions() {
        return pollRepository.getAllQuestions();
    }

    @Override
    public String answerTheQuestion(Answer answer) {
        if (answer.getAnswerNumber() == null || answer.getQuestionId() == null) {
            return "It is not possible to answer the question without answer number and question id";
        }
        if (answer.getAnswerNumber() < 1 || answer.getAnswerNumber() > 4) {
            return "The answer number must be between 1 and 4";
        }
        Question question = pollRepository.getQuestionById(answer.getQuestionId());
        if (question == null) {
            return "The question with this id does not exist, so it cannot be answered";
        }
        Integer isUserAnswerTheQuestion = pollRepository.isUserAnswerTheQuestion(answer.getQuestionId(), answer.getUserId());
        if (isUserAnswerTheQuestion != null && isUserAnswerTheQuestion == 1) {
            return "You have already answered this question";
        } else {
            return pollRepository.answerTheQuestion(answer);
        }
    }

    @Override
    public String deleteAnswersByUserId(Integer id) {
        if (id == null) {
            return "It is not possible to delete the user's answers without user id";
        }
        return pollRepository.deleteAnswersByUserId(id);
    }

    @Override
    public Integer getNumberOfAnswersToQuestion(Integer id) {
        if (id == null) {
            return -1; // No answer
        }
        Question question = pollRepository.getQuestionById(id);
        if (question == null) {
            return -1; // No answer
        }
        return pollRepository.getNumberOfAnswersToQuestion(id);
    }

    @Override
    public Integer getNumberOfAnswersPerUser(Integer id) {
        return pollRepository.getNumberOfAnswersPerUser(id);
    }

    @Override
    public String getHowManyUsersChooseEachOfQuestionOptions(Integer id) {
        if (id == null) {
            return "The id of the question must be passed";
        }
        Question question = pollRepository.getQuestionById(id);
        if (question == null) {
            return "The question with this id does not exist";
        }
        return pollRepository.getHowManyUsersChooseEachOfQuestionOptions(id);
    }

    @Override
    public String getUserAnswersToEachQuestionHeSubmitted(Integer id) {
        return pollRepository.getUserAnswersToEachQuestionHeSubmitted(id);
    }
}
