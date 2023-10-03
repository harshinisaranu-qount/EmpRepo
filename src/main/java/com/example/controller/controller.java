

package com.example.controller;

import com.example.Repo.UserRepo;

import com.example.model.Employee;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class controller {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getUserById(@PathVariable String id)
    {
        Optional<Employee> e=userRepo.findById(id);
        if (e!=null)
        {
            return new ResponseEntity<>(e, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> createEmp(@RequestBody Employee e){
        Employee em=userRepo.save(e);
        return new ResponseEntity<>(em,HttpStatus.CREATED);
    }

}

