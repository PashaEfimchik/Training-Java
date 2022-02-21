package by.epam.Efimchik.task1.dao;

import by.epam.Efimchik.task1.entities.User;

import java.util.List;

public interface UserDAO <T> {

    void add(T t) throws UserDAOException;

    void update(T t, String[] params) throws UserDAOException;

    void remove(int id) throws UserDAOException;

    T userById(int id) throws UserDAOException;

    List<T> allUsers() throws UserDAOException;

    List<T> search (String par) throws UserDAOException;
}
