package by.epam.Efimchik.task1.dao.impl;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.CartItem;
import by.epam.Efimchik.task1.entities.Product;
import by.epam.Efimchik.task1.entities.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CartItemDAOImplTest extends TestCase {
    private CartItemDAOImpl cartItemDAO;
    private CartItem cartItem;
    private User user;
    private Product product;

    @Before
    public void setUp() throws Exception {
        cartItemDAO = new CartItemDAOImpl();
        user = new User(111, "testEmail1@email.com", "testUsername1", "testPassword1", false);
        product = new Product(222, "testArticle", "testName", "testSupplierName", 250);
        cartItem = new CartItem(333, 5, 500, product, user);
    }

    @After
    public void tearDown() throws Exception {
        cartItem = null;
        product = null;
        user = null;
        cartItemDAO = null;
    }

    @Test
    public void testAddItemToCart() {
        List<CartItem> cartItemList = null;
        try {
            cartItemDAO.addItemToCart(cartItem);
            cartItemList = cartItemDAO.showCart(user).stream().distinct().collect(Collectors.toList());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(cartItem.getId(), cartItemList.get(0).getId());
    }

    @Test
    public void testShowCart() {
        List<CartItem> cartItemList = null;
        try {
            cartItemList = cartItemDAO.showCart(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2, cartItemList.size());
    }

    @Test
    public void testSearchCart() {
        CartItem searchCartItem = new CartItem();
        try {
            cartItemDAO.addItemToCart(cartItem);
            searchCartItem = cartItemDAO.searchCart(cartItem.getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(cartItem.getId(), searchCartItem.getId());
        Assert.assertEquals(cartItem.getQuantityItem(), searchCartItem.getQuantityItem());
    }

    @Test
    public void testRemoveItemFromCart() {
        List<CartItem> cartItemList = null;
        CartItem cartItem1 = new CartItem(444, 5, 500, product, user);
        try {
            cartItemDAO.addItemToCart(cartItem1);
            cartItemDAO.removeItemFromCart(cartItem1.getId());

            cartItemList = cartItemDAO.showCart(user).stream().distinct().collect(Collectors.toList());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(1, cartItemList.size());
    }
}