package com.example.orderdemo.model.dto.mapper;

import com.example.orderdemo.model.dto.UserDto;
import com.example.orderdemo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    User mapToUser(UserDto userDto);

    UserDto mapToUserDto(User user);

}
