package com.githubrepo.queryapp.exceptions.advice;

import com.githubrepo.queryapp.exceptions.ExceptionResponse;
import com.githubrepo.queryapp.exceptions.InvalidDateException;
import com.githubrepo.queryapp.exceptions.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Slf4j
public class CommonExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {
        return getExceptionResponse(ex, "Bad Request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDateException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidDateException(InvalidDateException ex, WebRequest request) {
        return getExceptionResponse(ex, ex.getStatus(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerException.class)
    public final ResponseEntity<ExceptionResponse> handleServerError(ServerException ex, WebRequest request) {
        return getExceptionResponse(ex, ex.getStatus(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    private ResponseEntity<ExceptionResponse> getExceptionResponse(Exception ex, String status, HttpStatus statusCode) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timeStamp(new Date()).status(status)
                .message(ex.getMessage()).build();
        log.error("Error: " + exceptionResponse.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, statusCode);
    }

}
