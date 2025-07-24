package org.example.springboot3mongodblearning.services;

import org.example.springboot3mongodblearning.domain.Post;
import org.example.springboot3mongodblearning.domain.User;
import org.example.springboot3mongodblearning.dto.PostCreationRequestDto;
import org.example.springboot3mongodblearning.dto.PostUpdateRequestDto;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(String id);
    Post create(PostCreationRequestDto dto, User author);
    Post update(String id, PostUpdateRequestDto dto);
    void delete(String id);
}