package com.example.orderdemo.mapper;

import com.example.orderdemo.model.dto.UserDto;
import com.example.orderdemo.model.entity.User;
import com.example.orderdemo.model.enums.Role;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {

    private final UserMapper userMapper;

    UserMapperTest() {
        userMapper = new UserMapperImpl();
    }

    @Test
    void mapToUserDto() {
        UUID randomId = UUID.randomUUID();

        User user = new User(randomId, Role.MANAGER, null);

        UserDto expected = new UserDto(randomId, Role.MANAGER, null);

        UserDto actual = userMapper.mapToUserDto(user);

        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getRole(), expected.getRole());
        assertEquals(actual.getOrders(), expected.getOrders());
    }

    @Test
    void mapToUser() {
        UUID randomId = UUID.randomUUID();

        UserDto user = new UserDto(randomId, Role.MANAGER, null);

        User expected = new User(randomId, Role.MANAGER, null);

        User actual = userMapper.mapToUser(user);

        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getRole(), expected.getRole());
        assertEquals(actual.getOrders(), expected.getOrders());
    }
}
