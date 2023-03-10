package com.luis.todolist.controllers;

import com.luis.todolist.DTOs.TaskRequestDTO;
import com.luis.todolist.DTOs.TaskResponseDTO;
import com.luis.todolist.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    @GetMapping
    public List<TaskResponseDTO> getTasks(){return taskService.getTasks();}

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO taskRequestDTO){return taskService.createTask(taskRequestDTO);}

    @PatchMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO taskRequestDTO){return taskService.updateTask(id, taskRequestDTO);}

    @GetMapping("/user/{id}")
    public List<TaskResponseDTO> getTasksByUserId(@PathVariable Long id){return taskService.getTasksByUserId(id);}

    @DeleteMapping("/{id}")
    public TaskResponseDTO deleteTask(@PathVariable Long id){return taskService.deleteTask(id);}

}
