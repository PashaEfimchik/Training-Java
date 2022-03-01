package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.*;
import by.epam.Efimchik.task1.services.CartService;
import by.epam.Efimchik.task1.services.OrderService;
import by.epam.Efimchik.task1.services.ProductService;
import by.epam.Efimchik.task1.services.UserService;

import java.util.List;
import java.util.Scanner;

public class OrderView {
    OrderService orderService = new OrderService();
    UserService userService = new UserService();
    ProductService productService = new ProductService();
    CartService cartService = new CartService();
    Scanner input = new Scanner(System.in);

    public void addOrder(Product product, User user, CartItem cartItem) throws DAOException {
        if (user.isUserSession()) {
            Order order = new Order();
            order.setProduct(product);
            order.setUser(user);
            order.setOrderQuantity(cartItem.getQuantityItem());
            order.setOrderTotal(cartItem.getTotalPrice());
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderStatusId(1);
            order.setOrderStatus(orderStatus);

            orderService.addOrder(order);

            if (orderService.showOrder(user).contains(order)) {
                System.out.println(" - Order details -");
                System.out.println("Order id: " + order.getOrderId() + "\nArticle: " + order.getProduct().getArticle() + "\nName: " + order.getProduct().getName() +
                        "\nSupplier name: " + order.getProduct().getSupplierName() + "\nTotal Price(BYN): " + order.getProduct().getProductPrice() + "Status: Ordered");
            }
        }
        else {
            System.out.println("Login to continue");
        }
    }

    public void showOrder(User user) throws DAOException {
        if (user.isUserSession()) {
            List<Order> orderList = orderService.showOrder(user);
            if (orderList.size() != 0) {
                Product product;
                System.out.println(" - My Orders -");
                for (var order : orderList) {
                    product = productService.productById(order.getProduct().getProductId());
                    System.out.println("ID: " + order.getOrderId() + "\t" + product.getName());
                }
            }
        }
        else {
            System.out.println("Login to continue");
        }
    }

    public void orderedProductDetail(User user, int orderId) throws DAOException {
        if (user.isUserSession()) {
            Order order = orderService.searchOrder(orderId);
            Product product = productService.productById(order.getProduct().getProductId());
            System.out.println(" - Order Details -");
            System.out.println("Order id: " + orderId + "\nArticle: " + product.getArticle() + "\nName: " + product.getName() +
                    "\nSupplier name: " + product.getSupplierName() + "\nQuantity: " + order.getOrderQuantity() + "\nTotal Price(BYN): " +
                    order.getOrderTotal() + "Order status: " + order.getOrderStatus().getOrderStatusType());
            System.out.println("1. Change status\n2. Back\nEnter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
            }

        }
        else {
            System.out.println("Login to continue");
        }
    }
}
