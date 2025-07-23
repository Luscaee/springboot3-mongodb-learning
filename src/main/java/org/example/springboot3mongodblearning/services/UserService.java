package org.example.springboot3mongodblearning.services;

import org.example.springboot3mongodblearning.domain.User;
import org.example.springboot3mongodblearning.dto.UserCreationRequest;
import org.example.springboot3mongodblearning.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String id);
    User create(UserCreationRequest dto);
    User update(String id, UserUpdateRequest dto);
    void delete(String id);
}