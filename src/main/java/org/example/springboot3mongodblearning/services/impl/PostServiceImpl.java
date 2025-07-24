package org.example.springboot3mongodblearning.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.springboot3mongodblearning.domain.Post;
import org.example.springboot3mongodblearning.domain.User;
import org.example.springboot3mongodblearning.dto.AuthorDto;
import org.example.springboot3mongodblearning.dto.PostCreationRequestDto;
import org.example.springboot3mongodblearning.dto.PostUpdateRequestDto;
import org.example.springboot3mongodblearning.repository.PostRepository;
import org.example.springboot3mongodblearning.services.PostService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(String id) {
        return null;
    }

    @Override
    public Post create(PostCreationRequestDto dto, User author) {
        Post post = new Post();

        AuthorDto authorPost =  new AuthorDto(author.getId(), author.getName());
        post.setAuthor(authorPost);

        post.setTitle(dto.getTitle());
        post.setBody(dto.getBody());
        post.setDate(Instant.now());

        return postRepository.save(post);
    }

    @Override
    public Post update(String id, PostUpdateRequestDto dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
