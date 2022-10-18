package com.githubrepo.queryapp.exceptions;

import lombok.Data;

@Data
public class ServerException extends Exception {

    private String message;
    private String status;

    public ServerException() {
        this.message = "Error occurred while trying to cannot to Github Server";
        this.status = "Server Error";
    }

}
