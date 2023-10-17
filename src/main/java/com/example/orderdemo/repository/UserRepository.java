package com.example.orderdemo.repository;

import com.example.orderdemo.model.dto.UserDto;
import com.example.orderdemo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    void deleteById(UUID id);

    UserDto findById(UUID id);
}