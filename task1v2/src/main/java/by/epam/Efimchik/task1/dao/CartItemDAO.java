package by.epam.Efimchik.task1.dao;

import by.epam.Efimchik.task1.entities.CartItem;
import by.epam.Efimchik.task1.entities.User;

import java.util.List;

public interface CartItemDAO<T> {
    List<T> showCart(User user) throws DAOException;

    void addItemToCart(T t) throws DAOException;

    void removeItemFromCart(int cartId) throws DAOException;

    T searchCart(int cartId) throws DAOException;
}
