package by.epam.Efimchik.task1.dao;

import by.epam.Efimchik.task1.entities.User;

import java.util.List;

public interface OrderDAO <T> {
    void addToOrder (T t) throws DAOException;

    List<T> showOrder(User user) throws DAOException;

    List<T> showAllOrders() throws DAOException;

    T searchUserOrder(int userId) throws DAOException;

    T searchOrder(int orderId) throws DAOException;
}
