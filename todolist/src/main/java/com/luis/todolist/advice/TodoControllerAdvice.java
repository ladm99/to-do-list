package com.luis.todolist.advice;

import com.luis.todolist.DTOs.ErrorDTO;
import com.luis.todolist.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = {"com.luis.todolist.controllers"})
@ResponseBody
public class TodoControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleBadRequestException(BadRequestException badRequestException){
        return new ErrorDTO(badRequestException.getMessage());
    }
}
