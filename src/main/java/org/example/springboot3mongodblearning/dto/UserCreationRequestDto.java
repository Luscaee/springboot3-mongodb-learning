package org.example.springboot3mongodblearning.dto;

import lombok.Data;
import org.example.springboot3mongodblearning.domain.User;

@Data
public class UserCreationRequestDto {

    private String name;
    private String email;
    private String password;

    public static User fromDto(UserCreationRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
