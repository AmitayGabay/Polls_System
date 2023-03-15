package com.example.polls_system.external_api;

import com.example.polls_system.model.UserIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "externalapi",
        url = "${externalApi.users.url}"
)
public interface UsersSystemService {
    @GetMapping(value = "", params = "id")
    UserIdResponse isRegistered(@RequestParam Integer id);
}
