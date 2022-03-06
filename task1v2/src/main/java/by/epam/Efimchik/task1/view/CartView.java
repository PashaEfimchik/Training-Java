package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.CartItem;
import by.epam.Efimchik.task1.entities.Product;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.CartService;
import by.epam.Efimchik.task1.services.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class CartView {
    CartService cartService = new CartService();
    ProductService productService = new ProductService();
    OrderView orderView = new OrderView();
    Scanner input = new Scanner(System.in);
    final Logger logger = Logger.getLogger(CartView.class);

    public CartView() throws IOException, ClassNotFoundException {
    }

    public void addProductToCart(int quantity, User user, Product product) throws DAOException {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setUser(user);
        cartItem.setQuantityItem(quantity);
        cartItem.setTotalPrice(product.getProductPrice() * quantity);

        cartService.addCart(cartItem);

        if (cartService.showCart(user).contains(cartItem)){
            logger.info("Product successfully added to cart\n");
        }
    }

    public void showUserCart(User user) throws DAOException, IOException, ClassNotFoundException {
        if (user.isUserSession()) {
            List<CartItem> cartItemList = cartService.showCart(user);
            int cartId = 1;
            if (cartItemList.size() != 0) {
                Product product;
                logger.info(" - My Cart -\n");
                CartItem cart = new CartItem();
                cartItemList.sort(cart);
                for (var cartItem : cartItemList) {
                    product = productService.productById(cartItem.getProduct().getProductId());
                    cartItem.setId(cartId++);
                    logger.info("ID: " + cartItem.getId() + "\t" + product.getArticle() + "\t" + product.getName() + "\t" + cartItem.getTotalPrice() + " (BYN)");
                }
                logger.info("");
                logger.info("1. Buy product");
                logger.info("2. Back");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        logger.info("Select product (id) from cart to buy: ");
                        var cartSelect = input.nextInt();
                        purchaseProduct(user, cartSelect);
                        break;
                    case 2:
                        UserView userView = new UserView();
                        userView.userMenu(user);
                        break;
                }
            }
            else{
                logger.info("Your cart is empty\n");
            }
        }
        else {
            logger.info("Login to continue");
        }
    }

    public void purchaseProduct (User user, int cartId) throws DAOException, IOException, ClassNotFoundException {
        if (user.isUserSession()) {
            CartItem cartItem = cartService.searchCart(cartId);
            Product product = productService.productById(cartItem.getProduct().getProductId());

            logger.info(" - Cart details -\n");
            logger.info("Cart id: " + cartId);
            logger.info("Article: " + product.getArticle());
            logger.info("Name: " + product.getName());
            logger.info("Supplier name: " + product.getSupplierName());
            logger.info("Quantity: " + cartItem.getQuantityItem());
            logger.info("Total Price(BYN): " + cartItem.getTotalPrice() + "\n");

            logger.info("1. Buy now");
            logger.info("2. Back\n");
            logger.info("Enter your choice: ");

            int choice = input.nextInt();
            switch (choice){
                case 1:
                    orderView.addOrder(product, user, cartItem);
                    cartService.removeItem(cartId);
                    break;
                case 2:
                    showUserCart(user);
                    break;
                default:
                    logger.info("Invalid input, enter number 1 or 2");
            }
        }
        else {
            logger.info("Login to continue");
        }
    }
}
