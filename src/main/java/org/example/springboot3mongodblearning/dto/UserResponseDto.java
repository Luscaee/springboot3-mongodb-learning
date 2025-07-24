package org.example.springboot3mongodblearning.dto;

import lombok.Data;
import org.example.springboot3mongodblearning.domain.User;

@Data
public class UserResponseDto {

    private String id;
    private String name;

    public static UserResponseDto fromUser(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        return userResponseDto;
    }
}
