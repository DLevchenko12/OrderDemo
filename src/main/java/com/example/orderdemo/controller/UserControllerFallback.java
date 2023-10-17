package com.example.orderdemo.controller;

import com.example.orderdemo.model.dto.UserDto;
import com.example.orderdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class UserControllerFallback implements UserController {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    public void createUser(UserDto user) {
        userService.createUser(user);
    }

    @Override
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
