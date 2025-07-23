package org.example.springboot3mongodblearning.dto;

import lombok.Data;
import org.example.springboot3mongodblearning.domain.User;

@Data
public class UserCreationRequest {

    private String name;
    private String email;

    public static User fromDto(UserCreationRequest dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
