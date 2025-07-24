package org.example.springboot3mongodblearning.dto;

import lombok.Data;

@Data
public class UserUpdateRequestDto {
    private String id;
    private String name;
    private String email;
}
