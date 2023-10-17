package com.example.orderdemo.service;

import com.example.orderdemo.model.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void createUser(UserDto user);

    List<UserDto> getUserList();

    UserDto getUserById(UUID id);

    void deleteUser(UUID id);
}
