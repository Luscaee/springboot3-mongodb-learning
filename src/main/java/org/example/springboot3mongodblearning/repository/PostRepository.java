package org.example.springboot3mongodblearning.repository;

import org.example.springboot3mongodblearning.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
