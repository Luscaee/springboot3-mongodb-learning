package org.example.springboot3mongodblearning.repository;

import org.example.springboot3mongodblearning.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
