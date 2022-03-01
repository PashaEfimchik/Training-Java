package by.epam.Efimchik.task1.services;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.UserDAOImpl;
import by.epam.Efimchik.task1.entities.User;

import java.util.List;

public class UserService {
    private UserDAOImpl userDAO = new UserDAOImpl();

    public void addUser(User user) throws DAOException {
        userDAO.add(user);
    }

    public List<User> showAllUsers() throws DAOException {
        return userDAO.allUsers();
    }

    public void updateUser(User user, String[] params) throws DAOException {
        userDAO.update(user, params);
    }

    public User userById(int id) throws DAOException {
        return userDAO.userById(id);
    }

    public List searchUserByParam(String param) throws DAOException {
        return userDAO.search(param);
    }

    public User searchUser(String username, String password) throws DAOException {
        return userDAO.searchUser(username, password);
    }

    public void removeUser(int id) throws DAOException {
        userDAO.remove(id);
    }

    public boolean isValidUsername(String username) throws DAOException {
        if (username.matches("^[A-Za-z]\\w{5,29}$")){
            return true;
        }
        else {
            throw new DAOException("Invalid entered username");
        }
    }

    public boolean isValidEmail(String email) throws DAOException {
        if (email.matches("^([A-Za-z0-9_-]+\\.)*[A-Za-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$")){
            return true;
        }
        else {
            throw new DAOException("Invalid entered Email");
        }
    }

    public boolean isValidPassword (String password) throws DAOException {
        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$")){
            return true;
        }
        else {
            throw new DAOException("Invalid entered password. \nPassword must contain at least 8 and no more than 20 upper and lower case characters and numbers");
        }
    }
}
