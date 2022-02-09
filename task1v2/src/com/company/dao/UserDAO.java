package com.company.dao;

import com.company.entities.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user) throws UserDAOException;

    boolean removeUserById(int id) throws UserDAOException;

    void uploadUsers () throws UserDAOException;

    User userById (int id) throws UserDAOException;

    List<User> selectAllUsers() throws UserDAOException;

    List<User> searchUser (String par) throws UserDAOException;
}
