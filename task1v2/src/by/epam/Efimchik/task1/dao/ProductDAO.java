package by.epam.Efimchik.task1.dao;

import by.epam.Efimchik.task1.entities.Product;

import java.util.List;

public interface ProductDAO <T>{
    void add (T t) throws ProductDAOException;

    void update(T t, String[] params) throws ProductDAOException;

    void remove (int id) throws ProductDAOException;

    T productById (int id) throws ProductDAOException;

    List<T> allProducts () throws ProductDAOException;

    List<T> search (String par) throws ProductDAOException;

}
