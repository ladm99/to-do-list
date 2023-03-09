package com.luis.todolist.services;

import com.luis.todolist.DTOs.TaskRequestDTO;
import com.luis.todolist.DTOs.TaskResponseDTO;

import java.util.List;

public interface TaskService {

    List<TaskResponseDTO> getTasks();

    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);

    TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO);
}
