package com.luis.todolist.services;

import com.luis.todolist.DTOs.UserRequestDTO;
import com.luis.todolist.DTOs.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
}
