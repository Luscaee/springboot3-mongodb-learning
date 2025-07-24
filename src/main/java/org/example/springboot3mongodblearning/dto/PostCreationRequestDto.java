package org.example.springboot3mongodblearning.dto;

import lombok.Data;

@Data
public class PostCreationRequestDto {
    private String title;
    private String body;
}
