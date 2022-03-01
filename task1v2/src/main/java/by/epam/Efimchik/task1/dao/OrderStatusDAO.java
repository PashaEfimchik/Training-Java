package by.epam.Efimchik.task1.dao;

public interface OrderStatusDAO {
    void updateOrderStatus(int orderStatusId, int orderId) throws DAOException;
}
