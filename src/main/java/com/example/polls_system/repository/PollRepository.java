package com.example.polls_system.repository;

import com.example.polls_system.model.Answer;
import com.example.polls_system.model.AnswersListResponse;
import com.example.polls_system.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PollRepository implements PollRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUESTION_TABLE = "question";
    private static final String ANSWER_TABLE = "answer";

    @Override
    public String createQuestion(Question question) {
        try {
            String sql = String.format("INSERT INTO %s (title, first_answer, second_answer, third_answer, fourth_answer) VALUES (?,?,?,?,?)", QUESTION_TABLE);
            jdbcTemplate.update(sql, question.getTitle(), question.getFirstAnswer(), question.getSecondAnswer(), question.getThirdAnswer(), question.getFourthAnswer());
            return "Question created successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Question getQuestionById(Integer id) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE id = ?", QUESTION_TABLE);
            Question question = jdbcTemplate.queryForObject(sql, new QuestionMapper(), id);
            return question;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateQuestion(Question question) {
        try {
            String sql = String.format("UPDATE %s SET title = ?, first_answer = ?, second_answer = ?, third_answer = ?, fourth_answer = ? WHERE id = ?", QUESTION_TABLE);
            jdbcTemplate.update(sql, question.getTitle(), question.getFirstAnswer(), question.getSecondAnswer(),
                    question.getThirdAnswer(), question.getFourthAnswer(), question.getId());
            return "Question updated successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteQuestionById(Integer id) {
        try {
            String sql = String.format("DELETE FROM %s WHERE id = ?", QUESTION_TABLE);
            jdbcTemplate.update(sql, id);
            return "Question deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String getAllQuestions() {
        try {
            String sql = String.format("SELECT * FROM %s", QUESTION_TABLE);
            List<Question> questions = jdbcTemplate.query(sql, new QuestionMapper());
            String resultString = "";
            for (int i = 0; i < questions.size(); i++) {
                resultString += questions.get(i).toString();
                resultString += getHowManyUsersChooseEachOfQuestionOptions(questions.get(i).getId()) + "\n";
            }
            return resultString;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String answerTheQuestion(Answer answer) {
        try {
            String sql = String.format("INSERT INTO %s (answer_number, question_id, user_id) VALUES (?,?,?)", ANSWER_TABLE);
            jdbcTemplate.update(sql, answer.getAnswerNumber(), answer.getQuestionId(), answer.getUserId());
            return "You answered the question successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteAnswersByUserId(Integer id) {
        try {
            Integer numberOfUserAnswers = getNumberOfAnswersPerUser(id);
            if(numberOfUserAnswers == 0){
                return " ";
            }
            String sql = String.format("DELETE FROM %s WHERE user_id = ?", ANSWER_TABLE);
            jdbcTemplate.update(sql, id);
            return "The user's answers have been successfully deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Integer getNumberOfAnswersToQuestion(Integer id) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE question_id = ?", ANSWER_TABLE);
            List<Answer> answers = jdbcTemplate.query(sql, new AnswerMapper(), id);
            return answers.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Integer isUserAnswerTheQuestion(Integer questionId, Integer userId) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE question_id = ? AND user_id = ?", ANSWER_TABLE);
            Answer answer = jdbcTemplate.queryForObject(sql, new AnswerMapper(), questionId, userId);
            if (answer == null) {
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Integer getNumberOfAnswersPerUser(Integer id) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE user_id = ?", ANSWER_TABLE);
            List<Answer> answers = jdbcTemplate.query(sql, new AnswerMapper(), id);
            return answers.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String getHowManyUsersChooseEachOfQuestionOptions(Integer id) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE question_id = ?", ANSWER_TABLE);
            AnswersListResponse answers = new AnswersListResponse(jdbcTemplate.query(sql, new AnswerMapper(), id));
            if (answers.getSize() == 0) {
                return "There are no answers to this question \n";
            }
            return answers.toQuestionOptions();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String getUserAnswersToEachQuestionHeSubmitted(Integer id) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE user_id = ?", ANSWER_TABLE);
            AnswersListResponse answers = new AnswersListResponse(jdbcTemplate.query(sql, new AnswerMapper(), id));
            return answers.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
