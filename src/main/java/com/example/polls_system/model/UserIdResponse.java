package com.example.polls_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserIdResponse {
    @JsonProperty("id")
    private Integer userId;

    public UserIdResponse() {

    }

    public UserIdResponse(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
