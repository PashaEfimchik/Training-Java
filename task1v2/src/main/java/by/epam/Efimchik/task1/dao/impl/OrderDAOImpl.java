package by.epam.Efimchik.task1.dao.impl;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.OrderDAO;
import by.epam.Efimchik.task1.entities.Order;
import by.epam.Efimchik.task1.entities.User;

import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO<Order> {
    private static List<Order> orderList = new ArrayList<>();

    @Override
    public void addToOrder(Order order) throws DAOException {
        orderList.add(new Order(order.getOrderId(), order.getProduct(), order.getUser(), order.getOrderTotal(), order.getOrderQuantity(), order.getOrderStatus()));
    }

    @Override
    public List<Order> showOrder (User user) throws DAOException {
        List<Order> userOrderList = new ArrayList<>();
        for (var order : orderList) {
            if (order.getUser().equals(user)) {
                userOrderList.add(order);
            }
        }
        return userOrderList;
    }

    @Override
    public List<Order> showAllOrders() throws DAOException {
        return orderList;
    }

    @Override
    public Order searchUserOrder(int userId) throws DAOException {
        for (var order : orderList) {
            if (order.getUser().getUserId() == userId) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order searchOrder(int orderId) throws DAOException {
        for (var order : orderList) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

}
