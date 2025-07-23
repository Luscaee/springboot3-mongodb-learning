package org.example.springboot3mongodblearning.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springboot3mongodblearning.domain.User;
import org.example.springboot3mongodblearning.dto.UserResponse;
import org.example.springboot3mongodblearning.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<User> userList = userService.findAll();
        List<UserResponse> responseList = userList.stream().map(UserResponse::fromUser).toList();
        return ResponseEntity.ok(responseList);
    }
}
