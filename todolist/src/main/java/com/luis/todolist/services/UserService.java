package com.luis.todolist.services;

import com.luis.todolist.DTOs.UserRequestDTO;
import com.luis.todolist.DTOs.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getUsers();
}
