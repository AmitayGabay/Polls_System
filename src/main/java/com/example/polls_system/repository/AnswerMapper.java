package com.example.polls_system.repository;

import com.example.polls_system.model.Answer;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper implements RowMapper<Answer> {
    @Override
    public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Answer(rs.getInt("id"),
                rs.getInt("answer_number"),
                rs.getInt("question_id"),
                rs.getInt("user_id"));
    }
}
