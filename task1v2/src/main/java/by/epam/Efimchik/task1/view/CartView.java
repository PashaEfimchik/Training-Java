package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.CartItem;
import by.epam.Efimchik.task1.entities.Product;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.services.CartService;
import by.epam.Efimchik.task1.services.ProductService;

import java.util.List;
import java.util.Scanner;

public class CartView {
    CartService cartService = new CartService();
    ProductService productService = new ProductService();
    OrderView orderView = new OrderView();
    Scanner input = new Scanner(System.in);

    public void addProductToCart(int quantity, User user, Product product) throws DAOException {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setUser(user);
        cartItem.setQuantityItem(quantity);
        cartItem.setTotalPrice(product.getProductPrice() * quantity);

        cartService.addCart(cartItem);

        if (cartService.showCart(user).contains(cartItem)){
            System.out.println("Product successfully added to cart");
        }
    }

    public void showUserCart(User user) throws DAOException {
        if (user.isUserSession()) {
            List<CartItem> cartItemList = cartService.showCart(user);
            if (cartItemList.size() != 0) {
                Product product;
                System.out.println(" - My Cart -");
                for (var cartItem : cartItemList) {
                    product = productService.productById(cartItem.getProduct().getProductId());
                    System.out.println("ID: " + cartItem.getId() + "\t" + product.getName());
                }
                System.out.println("Select product from cart to buy: ");
                var cartSelect = input.nextInt();
                purchaseProduct(user, cartSelect);
            }
            else{
                System.out.println("Your cart is empty");
            }
        }
        else {
            System.out.println("Login to continue");
        }
    }

    public void purchaseProduct (User user, int cartId) throws DAOException {
        if (user.isUserSession()) {
            CartItem cartItem = cartService.searchCart(cartId);
            Product product = productService.productById(cartItem.getProduct().getProductId());
            System.out.println(" - Cart details -");
            System.out.println("Cart id: " + cartId);
            System.out.println("Article: " + product.getArticle() + "\nName: " + product.getName() + "\nSupplier name: " + product.getSupplierName() +
                    "\nQuantity: " + cartItem.getQuantityItem() + "\nTotal Price(BYN): " + cartItem.getTotalPrice());
            System.out.println("\n1. Buy now\n2. Back\nEnter your choice: ");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    System.out.println("Back to menu");
                    break;
                default:
                    System.out.println("Invalid input, enter number 1/2");
            }

        }
        else {
            System.out.println("Login to continue");
        }
    }
}
