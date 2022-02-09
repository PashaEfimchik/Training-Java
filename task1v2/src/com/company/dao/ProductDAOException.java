package com.company.dao;

public class ProductDAOException extends Exception{
    public ProductDAOException() {}

    public ProductDAOException(String message, Throwable cause){
        super(message, cause);
    }

    public ProductDAOException(String message){
        super(message);
    }
}
