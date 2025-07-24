package org.example.springboot3mongodblearning.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springboot3mongodblearning.domain.User;
import org.example.springboot3mongodblearning.dto.UserCreationRequestDto;
import org.example.springboot3mongodblearning.dto.UserResponseDto;
import org.example.springboot3mongodblearning.dto.UserUpdateRequestDto;
import org.example.springboot3mongodblearning.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        List<User> userList = userService.findAll();
        List<UserResponseDto> responseList = userList.stream().map(UserResponseDto::fromUser).toList();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(UserResponseDto.fromUser(user));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserCreationRequestDto dto) {
        User obj = userService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable String id, @RequestBody UserUpdateRequestDto dto) {
        User obj = userService.update(id, dto);
        UserResponseDto userResponseDto = UserResponseDto.fromUser(obj);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
