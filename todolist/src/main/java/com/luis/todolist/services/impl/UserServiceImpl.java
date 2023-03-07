package com.luis.todolist.services.impl;

import com.luis.todolist.DTOs.UserRequestDTO;
import com.luis.todolist.DTOs.UserResponseDTO;
import com.luis.todolist.entities.User;
import com.luis.todolist.mappers.UserMapper;
import com.luis.todolist.repositories.UserRepository;
import com.luis.todolist.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User userToAdd = new User();
        userToAdd.setName(userRequestDTO.getName());
        return userMapper.entityToDTO(userRepository.saveAndFlush(userToAdd));
    }
}
