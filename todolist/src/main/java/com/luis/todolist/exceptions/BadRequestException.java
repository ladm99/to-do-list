package com.luis.todolist.exceptions;

import lombok.*;

import java.io.Serial;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BadRequestException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -3068232824365469297L;

    private String message;
}
