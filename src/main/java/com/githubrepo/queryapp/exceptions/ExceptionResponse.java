package com.githubrepo.queryapp.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ExceptionResponse {
    private Date timeStamp;
    private String status;
    private String message;
}
