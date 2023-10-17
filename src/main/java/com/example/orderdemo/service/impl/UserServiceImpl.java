package com.example.orderdemo.service.impl;

import com.example.orderdemo.model.dto.UserDto;
import com.example.orderdemo.model.dto.mapper.UserMapper;
import com.example.orderdemo.repository.UserRepository;
import com.example.orderdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    @Override
    public void createUser(UserDto user) {
        userRepository.saveAndFlush(userMapper.mapToUser(user));
    }

    @Override
    public List<UserDto> getUserList() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
