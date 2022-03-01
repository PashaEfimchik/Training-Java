package by.epam.Efimchik.task1.services;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.CartItemDAOImpl;
import by.epam.Efimchik.task1.entities.CartItem;
import by.epam.Efimchik.task1.entities.User;

import java.util.List;

public class CartService {
    private CartItemDAOImpl cartItemDAO = new CartItemDAOImpl();

    public void addCart(CartItem cartItem) throws DAOException {
        cartItemDAO.addItemToCart(cartItem);
    }

    public void removeItem(int cartItemId) throws DAOException {
        cartItemDAO.removeItemFromCart(cartItemId);
    }

    public List<CartItem> showCart(User user) throws DAOException {
        return cartItemDAO.showCart(user);
    }

    public CartItem searchCart(int cartItemId) throws DAOException {
        return cartItemDAO.searchCart(cartItemId);
    }
}
