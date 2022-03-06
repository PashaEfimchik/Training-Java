package by.epam.Efimchik.task1.dao;

import by.epam.Efimchik.task1.entities.User;

import java.util.List;

public interface UserDAO <T> {

    void add(T t) throws DAOException;

    void update(T t, String[] params) throws DAOException;

    void remove(int id) throws DAOException;

    User userById(int id) throws DAOException;

    List<T> allUsers() throws DAOException;

    List<T> search (String par) throws DAOException;

    T searchUser(String username, String password) throws DAOException;

    boolean isUsernameExist(String username) throws DAOException;

    boolean isEmailExist(String email) throws DAOException;

    boolean isPasswordExist(String username, String password) throws DAOException;

}
