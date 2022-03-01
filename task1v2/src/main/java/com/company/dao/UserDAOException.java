package com.company.dao;

public class UserDAOException extends Exception {
    public UserDAOException() {}

    public UserDAOException(String message, Throwable cause){
        super(message, cause);
    }

    public UserDAOException(String message){
        super(message);
    }
}
