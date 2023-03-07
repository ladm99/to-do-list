package com.luis.todolist.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private boolean finished;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
