package com.luis.todolist.mappers;

import com.luis.todolist.DTOs.UserRequestDTO;
import com.luis.todolist.DTOs.UserResponseDTO;
import com.luis.todolist.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToEntity(User user);

    List<UserResponseDTO> entitiesToDTOs(List<User> users);

    User requestDTOToEntity(UserRequestDTO userRequestDTO);

    UserResponseDTO entityToDTO(User user);
}
