package com.cinema.backend.service;

import com.cinema.backend.dto.FilmDto;
import com.cinema.backend.dto.UserDto;
import com.cinema.backend.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUsername(Long userId) throws ResourceNotFoundException;
    UserDto updateUser(Long userId, UserDto updatedUser) throws ResourceNotFoundException;
    void deleteUser(Long userId) throws ResourceNotFoundException;
    List<UserDto> getAllUsers();
}
