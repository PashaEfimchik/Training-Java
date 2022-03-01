package by.epam.Efimchik.task1.dao;

import by.epam.Efimchik.task1.entities.Product;

import java.util.List;

public interface ProductDAO <T>{
    void add (T t) throws DAOException;

    void update(T t, String[] params) throws DAOException;

    void remove (int id) throws DAOException;

    T productById (int id) throws DAOException;

    List<T> allProducts () throws DAOException;

    List<T> search (String par) throws DAOException;

}
