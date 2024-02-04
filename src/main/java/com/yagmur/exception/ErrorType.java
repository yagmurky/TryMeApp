package com.yagmur.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR_SERVER(5100,"Server error",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100,"Parameter error",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4101,"This user not found",HttpStatus.NOT_FOUND),
    LOGIN_ERROR(4202 ,"Password or username is not correct",HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXISTS(4303,"User already exists",HttpStatus.BAD_REQUEST)
    ;
    private  int code;
    private String message;
    HttpStatus httpStatus;
}