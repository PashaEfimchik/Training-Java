package com.company.services;

import com.company.dao.UserDAO;
import com.company.entities.User;
import com.company.dao.UserDAOException;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    List<User> userList = new ArrayList<>();

    @Override
    public boolean addUser(User user) throws UserDAOException {
        return userList.add(user);
    }

    @Override
    public List<User> selectAllUsers () {
        return userList;
    }

    @Override
    public User userById (int id) {
        for (User user : userList) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> searchUser (String par) {
        List<User> searchUserList = new ArrayList<>();
        for (User user : userList) {
            if (user.getUsername().contains(par)) {
                searchUserList.add(user);
            }
        }
        return searchUserList;
    }

    @Override
    public boolean removeUserById (int id) {
        User user = userById(id);

        if (user != null){
            return userList.remove(user);
        }
        return false;
    }

    @Override
    public void uploadUsers(List<User> listUser) {

    }
}
