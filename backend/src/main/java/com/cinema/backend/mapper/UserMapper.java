package com.cinema.backend.mapper;

import com.cinema.backend.dto.UserDto;
import com.cinema.backend.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword()
        );
    }
}
