package com.example.demo;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private String error;
    private int status;

    public ErrorResponse(String error, int status){
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
    }
    public String getError(){
        return error;
    }
    public int getStatus(){
        return status;
    }
    public LocalDateTime getTimestamp(){return timestamp; }
}
