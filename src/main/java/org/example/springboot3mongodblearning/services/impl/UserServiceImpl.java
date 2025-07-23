package org.example.springboot3mongodblearning.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.springboot3mongodblearning.domain.User;
import org.example.springboot3mongodblearning.dto.UserCreationRequest;
import org.example.springboot3mongodblearning.dto.UserUpdateRequest;
import org.example.springboot3mongodblearning.repository.UserRepository;
import org.example.springboot3mongodblearning.services.UserService;
import org.example.springboot3mongodblearning.services.exception.BusinessException;
import org.example.springboot3mongodblearning.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }

    @Override
    public User create(UserCreationRequest dto) {
        userRepository.findByEmail(dto.getEmail()).ifPresent(user -> {
            throw new BusinessException("Email already exists");
        });

        User user = UserCreationRequest.fromDto(dto);
        return userRepository.save(user);
    }

    @Override
    public User update(String id, UserUpdateRequest dto) {
        return null;
    }

    @Override
    public void delete(String id) {
        //
    }
}
