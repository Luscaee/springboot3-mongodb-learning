package org.example.springboot3mongodblearning.dto;

import lombok.Data;
import org.example.springboot3mongodblearning.domain.User;

@Data
public class UserResponse {

    private String id;
    private String name;

    public static UserResponse fromUser(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        return userResponse;
    }
}
