package by.epam.Efimchik.task1.dao;

public class DAOException extends Exception{
    public DAOException() {}

    public DAOException(String message, Throwable cause){
        super(message, cause);
    }

    public DAOException(String message){
        super(message);
    }
}
