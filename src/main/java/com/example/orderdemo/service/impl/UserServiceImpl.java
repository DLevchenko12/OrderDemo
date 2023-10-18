package com.example.orderdemo.service.impl;

import com.example.orderdemo.mapper.UserMapper;
import com.example.orderdemo.model.dto.UserDto;
import com.example.orderdemo.repository.UserRepository;
import com.example.orderdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(UserDto user) {
        userRepository.save(userMapper.mapToUser(user));
    }

    @Override
    public List<UserDto> getUserList() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(UUID id) {
        return userMapper.mapToUserDto(userRepository.findById(id));
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
