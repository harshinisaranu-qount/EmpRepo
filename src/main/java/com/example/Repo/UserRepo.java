package com.example.Repo;

import com.example.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<Employee,String> {
}
