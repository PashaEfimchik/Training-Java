package by.epam.Efimchik.task1.dao.impl;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.OrderStatusDAO;

public class OrderStatusDAOImpl implements OrderStatusDAO {
    private OrderDAOImpl orderDAO = new OrderDAOImpl();

    @Override
    public void updateOrderStatus(int orderStatusId, int orderId) throws DAOException {
        for (var order : orderDAO.showAllOrders()) {
            if (order.getOrderId() == orderId) {
                order.getOrderStatus().setOrderStatusId(orderStatusId);
            }
        }
    }

}
