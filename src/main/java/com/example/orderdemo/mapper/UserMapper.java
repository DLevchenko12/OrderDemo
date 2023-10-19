package com.example.orderdemo.mapper;

import com.example.orderdemo.model.dto.UserDto;
import com.example.orderdemo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    User mapToUser(UserDto userDto);

    UserDto mapToUserDto(User user);
}
