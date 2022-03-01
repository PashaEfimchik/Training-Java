package by.epam.Efimchik.task1.dao.impl;

import by.epam.Efimchik.task1.dao.CartItemDAO;
import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.CartItem;
import by.epam.Efimchik.task1.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartItemDAOImpl implements CartItemDAO<CartItem> {
    private List<CartItem> cartItemList = new ArrayList<>();

    public CartItemDAOImpl() { }

    @Override
    public List<CartItem> showCart(User user) throws DAOException {
        return cartItemList;
    }

    @Override
    public void addItemToCart(CartItem cartItem) throws DAOException {
        cartItemList.add(new CartItem(cartItem.getId(), cartItem.getQuantityItem(), cartItem.getTotalPrice(), cartItem.getProduct(), cartItem.getUser()));
    }

    @Override
    public void removeItemFromCart(int cartItemId) throws DAOException {
        Iterator<CartItem> iterator = cartItemList.iterator();
        while (iterator.hasNext()){
            CartItem cartItem = iterator.next();
            if (cartItem.getId() == cartItemId){
                iterator.remove();
            }
        }
    }

    @Override
    public CartItem searchCart(int cartItemId) throws DAOException {
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getId() == cartItemId) {
                return cartItem;
            }
        }
        return null;

    }




}
