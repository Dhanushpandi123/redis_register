package com.redis_register.redis_register.repository;

import com.redis_register.redis_register.entities.RegisterEntities;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterRepository extends MongoRepository<RegisterEntities, String> {
}
