package com.luis.todolist.controllers;

import com.luis.todolist.DTOs.UserRequestDTO;
import com.luis.todolist.DTOs.UserResponseDTO;
import com.luis.todolist.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDTO> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.createUser(userRequestDTO);
    }
}
