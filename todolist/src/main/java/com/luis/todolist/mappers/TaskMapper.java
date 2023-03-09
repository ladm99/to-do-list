package com.luis.todolist.mappers;

import com.luis.todolist.DTOs.TaskRequestDTO;
import com.luis.todolist.DTOs.TaskResponseDTO;
import com.luis.todolist.entities.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task dtoToEntity(TaskRequestDTO taskRequestDTO);

    List<TaskResponseDTO> entitiesToDTOs(List<Task> tasks);

    List<Task> dtosToEntities(List<TaskResponseDTO> taskResponseDTOs);

    TaskResponseDTO entityToDTO(Task task);
}
