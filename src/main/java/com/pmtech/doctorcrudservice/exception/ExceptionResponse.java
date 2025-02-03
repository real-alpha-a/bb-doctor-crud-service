package com.pmtech.doctorcrudservice.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public class ExceptionResponse {
    private Date timestamp;
    private String code;
    private String message;
    private List<String> details;

    public ExceptionResponse(HttpStatus statusCode,String message, List<String> details ) {
        super();
        this.timestamp = new Date();
        this.code = statusCode.toString();
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "timestamp=" + timestamp +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", details=" + details +
                '}';
    }
}
