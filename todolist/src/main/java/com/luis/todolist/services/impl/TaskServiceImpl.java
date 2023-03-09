package com.luis.todolist.services.impl;

import com.luis.todolist.DTOs.TaskRequestDTO;
import com.luis.todolist.DTOs.TaskResponseDTO;
import com.luis.todolist.entities.Task;
import com.luis.todolist.entities.User;
import com.luis.todolist.exceptions.BadRequestException;
import com.luis.todolist.mappers.TaskMapper;
import com.luis.todolist.repositories.TaskRepository;
import com.luis.todolist.repositories.UserRepository;
import com.luis.todolist.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskResponseDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.entitiesToDTOs(tasks);
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task taskToAdd = taskMapper.dtoToEntity(taskRequestDTO);
        Optional<User> user = userRepository.findById(taskRequestDTO.getUser().getId());

        if(user.isEmpty())
            throw new BadRequestException("User does not exist");

        taskToAdd.setUser(user.get());
        taskRepository.saveAndFlush(taskToAdd);
        List<Task> tasks = user.get().getTasks();
        tasks.add(taskToAdd);
        user.get().setTasks(tasks);
        userRepository.saveAndFlush(user.get());
        return taskMapper.entityToDTO(taskToAdd);
    }
}
