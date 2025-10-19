package com.freightportal.repo;

import com.freightportal.model.Load;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends MongoRepository<Load, String> {
    // Add custom queries later (find by city, etc.)
}
