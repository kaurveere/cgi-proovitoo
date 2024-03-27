package com.cinema.backend.controller;

import com.cinema.backend.dto.FilmDto;
import com.cinema.backend.dto.UserDto;
import com.cinema.backend.entity.User;
import com.cinema.backend.exception.ResourceNotFoundException;
import com.cinema.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/login")
public class LoginController {

    private UserService userService;

    //Create user
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    //Get user by username
    @GetMapping("/{username}/{password}")
    public ResponseEntity<String> getUserByUsernameAndPassword(
            @PathVariable("username") String username,
            @PathVariable("password") String password) {

        UserDto userDto = null;

        List<UserDto> users = userService.getAllUsers();

        for(UserDto user : users){
            if (user.getUsername().equals(username)){
                userDto = user;

                boolean passwordMatches = password.equals(userDto.getPassword());

                if (passwordMatches) {
                    return ResponseEntity.ok("Login successful");
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
                }
            }

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
    }
    //Update user
    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto updatedUser) throws ResourceNotFoundException {
        UserDto userDto = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(userDto);
    }
    //Delete User
    @DeleteMapping("{userId}")
    ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) throws ResourceNotFoundException {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

}
