package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRespository extends MongoRepository<User, Integer> {
	User findByName(String name);

	User findById(String id);

}
