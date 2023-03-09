package com.luis.todolist.services.impl;

import com.luis.todolist.DTOs.UserRequestDTO;
import com.luis.todolist.DTOs.UserResponseDTO;
import com.luis.todolist.entities.User;
import com.luis.todolist.exceptions.BadRequestException;
import com.luis.todolist.mappers.UserMapper;
import com.luis.todolist.repositories.UserRepository;
import com.luis.todolist.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<UserResponseDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.entitiesToDTOs(users);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new BadRequestException("User with id: " + id + " does not exist");
        return userMapper.entityToDTO(user.get());
    }

    @Override
    public UserResponseDTO deleteUserById(Long id) {
        Optional<User> userToDelete = userRepository.findById(id);
        if(userToDelete.isEmpty())
            throw new BadRequestException("User with id: " + id + " does not exist");
        userRepository.delete(userToDelete.get());
        return userMapper.entityToDTO(userToDelete.get());
    }
}
