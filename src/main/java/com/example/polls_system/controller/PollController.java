package com.example.polls_system.controller;

import com.example.polls_system.model.Answer;
import com.example.polls_system.model.UserIdResponse;
import com.example.polls_system.external_api.UsersSystemService;
import com.example.polls_system.model.Question;
import com.example.polls_system.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/polls")
public class PollController {
    @Autowired
    PollService pollService;

    @Autowired
    private UsersSystemService usersSystemService;

    @PostMapping(value = "/create")
    public String createQuestion(@RequestBody Question question) {
        return pollService.createQuestion(question);
    }

    @GetMapping(params = "id")
    public Question getQuestionById(@RequestParam Integer id) {
        return pollService.getQuestionById(id);
    }

    @PutMapping(value = "/update")
    public String updateQuestion(@RequestBody Question question) {
        return pollService.updateQuestion(question);
    }

    @DeleteMapping(value = "/delete", params = "id")
    public String deleteQuestionById(@RequestParam Integer id) {
        return pollService.deleteQuestionById(id);
    }

    @GetMapping(value = "/all")
    public String getAllQuestions() {
        return pollService.getAllQuestions();
    }

    @PostMapping(value = "/answer-the-question")
    public String answerTheQuestion(@RequestBody Answer answer) {
        if (answer.getUserId() == null) {
            return "You cannot answer the question without your user id";
        }
        UserIdResponse userIdResponse = usersSystemService.isRegistered(answer.getUserId());
        if (userIdResponse == null) {
            return "You cannot answer the survey before you have registered";
        } else {
            return pollService.answerTheQuestion(answer);
        }
    }

    @DeleteMapping(value = "/delete-answers-by-user", params = "id")
    public String deleteAnswersByUserId(@RequestParam Integer id) {
        return pollService.deleteAnswersByUserId(id);
    }

    @GetMapping(value = "/numbers-of-answers-to-question", params = "id")
    public Integer getNumberOfAnswersToQuestion(@RequestParam Integer id) {
        return pollService.getNumberOfAnswersToQuestion(id);
    }

    @GetMapping(value = "/numbers-of-answers-per-user", params = "id")
    public Integer getNumberOfAnswersPerUser(@RequestParam Integer id) {
        if (id == null) {
            return -1; // No answer
        }
        UserIdResponse userIdResponse = usersSystemService.isRegistered(id);
        if (userIdResponse == null) {
            return -1; // No answer
        } else {
            return pollService.getNumberOfAnswersPerUser(id);
        }
    }

    @GetMapping(value = "/how-many-users-choose-each-of-question-options", params = "id")
    public String getHowManyUsersChooseEachOfQuestionOptions(@RequestParam Integer id) {
        return pollService.getHowManyUsersChooseEachOfQuestionOptions(id);
    }

    @GetMapping(value = "/user-answers-to-each-question-he-submitted", params = "id")
    public String getUserAnswersToEachQuestionHeSubmitted(@RequestParam Integer id) {
        if (id == null) {
            return "The id of the user must be passed";
        }
        UserIdResponse userIdResponse = usersSystemService.isRegistered(id);
        if (userIdResponse == null) {
            return "The user with this id does not exist";
        } else {
            return pollService.getUserAnswersToEachQuestionHeSubmitted(id);
        }
    }
}
