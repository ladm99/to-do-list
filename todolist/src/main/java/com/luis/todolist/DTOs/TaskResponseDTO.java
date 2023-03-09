package com.luis.todolist.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskResponseDTO {
    private Long id;
    private String description;
    private boolean finished;
}
