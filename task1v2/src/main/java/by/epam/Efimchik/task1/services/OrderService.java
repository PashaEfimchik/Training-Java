package by.epam.Efimchik.task1.services;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.OrderDAOImpl;
import by.epam.Efimchik.task1.entities.Order;
import by.epam.Efimchik.task1.entities.User;

import java.util.List;

public class OrderService {
    private OrderDAOImpl orderDAO = new OrderDAOImpl();

    public void addOrder(Order order) throws DAOException {
        orderDAO.addToOrder(order);
    }

    public List<Order> showAllOrders() throws DAOException {
        return orderDAO.showAllOrders();
    }

    public List<Order> showOrder(User user) throws DAOException {
        return orderDAO.showOrder(user);
    }

    public Order searchOrder(int orderId) throws DAOException {
        return orderDAO.searchOrder(orderId);
    }

    public Order searchUserOrder(int userId) throws DAOException {
        return orderDAO.searchUserOrder(userId);
    }
}
