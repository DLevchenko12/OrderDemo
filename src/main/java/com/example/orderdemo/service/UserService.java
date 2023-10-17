package com.example.orderdemo.service;

import com.example.orderdemo.model.dto.UserDto;

import java.util.List;

public interface UserService {

    void createUser(UserDto user);

    List<UserDto> getUserList();

    void deleteUser(Long id);
}
