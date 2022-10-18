package com.githubrepo.queryapp.exceptions;

import lombok.Data;

@Data
public class InvalidDateException extends Exception {

    private String message;
    private String status;

    public InvalidDateException() {
        this.message = "Given date is not a recognized date format. Please provide a date in YYYY-MM-DD format";
        this.status = "Bad Request";
    }

}
