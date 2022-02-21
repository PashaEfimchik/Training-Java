package by.epam.Efimchik.task1.dao;

public class ProductDAOException extends Exception{
    public ProductDAOException() {}

    public ProductDAOException(String message, Throwable cause){
        super(message, cause);
    }

    public ProductDAOException(String message){
        super(message);
    }
}
