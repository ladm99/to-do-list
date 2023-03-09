package com.luis.todolist.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String name;

    private List<TaskResponseDTO> tasks;
}
