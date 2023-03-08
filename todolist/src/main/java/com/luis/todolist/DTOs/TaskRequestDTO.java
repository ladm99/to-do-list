package com.luis.todolist.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskRequestDTO {

    private String description;
    private boolean finished;
    private UserResponseDTO user;

}
