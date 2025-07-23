package org.example.springboot3mongodblearning.dto;

import lombok.Data;

@Data
public class UserCreationRequest {

    private String name;
    private String email;
}
