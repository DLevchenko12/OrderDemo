package com.example.orderdemo.service.impl;

import com.example.orderdemo.mapper.UserMapper;
import com.example.orderdemo.model.dto.UserDto;
import com.example.orderdemo.repository.UserRepository;
import com.example.orderdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private static final String MESSAGE = "Entity is not presented.";

    @Override
    public void createUser(UserDto user) {
        userRepository.save(userMapper.mapToUser(user));
    }

    @Override
    public List<UserDto> getUserList() {
        if (userRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException(MESSAGE);
        }
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(UUID id) {
        if (Objects.equals(userRepository.findById(id), null)) {
            throw new ResourceNotFoundException(MESSAGE);
        }
        return userMapper.mapToUserDto(userRepository.findById(id));
    }

    @Override
    public void deleteUser(UUID id) {
        if (Objects.equals(userRepository.findById(id), null)) {
            throw new ResourceNotFoundException(MESSAGE);
        }
        userRepository.deleteById(id);
    }
}
