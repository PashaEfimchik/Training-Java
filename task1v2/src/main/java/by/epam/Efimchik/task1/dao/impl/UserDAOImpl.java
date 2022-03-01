package by.epam.Efimchik.task1.dao.impl;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.UserDAO;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.utils.InitializationUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDAOImpl implements UserDAO<User> {
    private static List<User> userList = new ArrayList<>();

    public UserDAOImpl() {
        InitializationUtil initializationUtil = new InitializationUtil();
        initializationUtil.uploadUsers(userList);
    }

    @Override
    public void add(User user) throws DAOException {
        userList.add(user);
    }

    @Override
    public void update(User user, String[] params) throws DAOException {
        user.setUserId(Integer.valueOf(Objects.requireNonNull(params[0])));
        user.setEmail(Objects.requireNonNull(params[1]));
        user.setUsername(Objects.requireNonNull(params[2]));
        user.setPassword(Objects.requireNonNull(params[3]));
    }

    @Override
    public List<User> allUsers() {
        return userList;
    }

    @Override
    public User userById(int id) {
        for (User user : userList) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }
    @Override
    public User searchUser(String username, String password) throws DAOException {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> search(String par) {
        List<User> searchUserList = new ArrayList<>();
        for (User user : userList) {
            if (user.getUsername().contains(par) || user.getEmail().contains(par)) {
                searchUserList.add(user);
            }
        }
        return searchUserList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUserId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public boolean isUsernameExist(String username) throws DAOException {
        for (var user : userList) {
            return user.getUsername().equals(username);
        }
        return false;
    }

    @Override
    public boolean isEmailExist(String email) throws DAOException {
        for (var user : userList) {
            return user.getEmail().equals(email);
        }
        return false;
    }

    @Override
    public boolean isPasswordExist(String username, String password) throws DAOException {
        for (var user : userList) {
            return user.getUsername().equals(username) && user.getPassword().equals(password);
        }
        return false;
    }
}
