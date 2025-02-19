package com.example.todobackend.entity;

import java.time.LocalDateTime;

public class ErrorDetail {
    private LocalDateTime localDateTime;
    private String message;
    private String detail;

    public ErrorDetail() {
    }

    public ErrorDetail(LocalDateTime localDateTime, String message, String detail) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.detail = detail;
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
