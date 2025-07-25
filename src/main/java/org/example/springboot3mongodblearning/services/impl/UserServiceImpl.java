package org.example.springboot3mongodblearning.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.springboot3mongodblearning.domain.User;
import org.example.springboot3mongodblearning.dto.UserCreationRequestDto;
import org.example.springboot3mongodblearning.dto.UserUpdateRequestDto;
import org.example.springboot3mongodblearning.repository.UserRepository;
import org.example.springboot3mongodblearning.services.UserService;
import org.example.springboot3mongodblearning.services.exception.BusinessException;
import org.example.springboot3mongodblearning.services.exception.ObjectNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
    public User create(UserCreationRequestDto dto) {
        userRepository.findByEmail(dto.getEmail()).ifPresent(user -> {
            throw new BusinessException("Email already exists");
        });

        User user = UserCreationRequestDto.fromDto(dto);
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    @Override
    public User update(String id, UserUpdateRequestDto dto) {
        User existingUser = findById(id);
        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
