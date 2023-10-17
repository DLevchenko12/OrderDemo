package com.example.orderdemo.controller;

import com.example.orderdemo.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public interface UserController {

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers();

    @PostMapping
    void createUser(UserDto user);

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id);

}
