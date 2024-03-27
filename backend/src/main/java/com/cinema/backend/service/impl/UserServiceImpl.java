package com.cinema.backend.service.impl;

import com.cinema.backend.dto.FilmDto;
import com.cinema.backend.dto.UserDto;
import com.cinema.backend.entity.Film;
import com.cinema.backend.entity.User;
import com.cinema.backend.exception.ResourceNotFoundException;
import com.cinema.backend.mapper.FilmMapper;
import com.cinema.backend.mapper.UserMapper;
import com.cinema.backend.repository.UserRepository;
import com.cinema.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserByUsername(Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist by id: "+userId));

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist by id: "+userId));

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist by id: "+userId));

        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }
}
