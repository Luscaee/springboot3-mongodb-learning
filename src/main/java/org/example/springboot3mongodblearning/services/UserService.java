package org.example.springboot3mongodblearning.services;

import org.example.springboot3mongodblearning.domain.User;
import org.example.springboot3mongodblearning.dto.UserCreationRequestDto;
import org.example.springboot3mongodblearning.dto.UserUpdateRequestDto;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String id);
    User create(UserCreationRequestDto dto);
    User update(String id, UserUpdateRequestDto dto);
    void delete(String id);
}