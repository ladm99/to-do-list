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

    @Override
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty())
            throw new BadRequestException("Task does not exist");

        task.get().setFinished(taskRequestDTO.isFinished());
        taskRepository.saveAndFlush(task.get());
        return taskMapper.entityToDTO(task.get());
    }

    @Override
    public List<TaskResponseDTO> getTasksByUserId(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new BadRequestException("User does not exist");

        List<Task> tasks = user.get().getTasks();
        return taskMapper.entitiesToDTOs(tasks);
    }
}
