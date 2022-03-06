package by.epam.Efimchik.task1.view;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.*;
import by.epam.Efimchik.task1.services.OrderService;
import by.epam.Efimchik.task1.services.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class OrderView {
    final Logger logger = Logger.getLogger(OrderView.class);
    OrderService orderService = new OrderService();
    ProductService productService = new ProductService();
    private static int orderId = 1;
    Scanner input = new Scanner(System.in);

    public OrderView() throws IOException, ClassNotFoundException {
    }

    public void addOrder(Product product, User user, CartItem cartItem) throws DAOException {
        if (user.isUserSession()) {
            Order order = new Order();
            order.setOrderId(orderId++);
            order.setProduct(product);
            order.setUser(user);
            order.setOrderQuantity(cartItem.getQuantityItem());
            order.setOrderTotal(cartItem.getTotalPrice());
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderStatusId(1);
            order.setOrderStatus(orderStatus);

            orderService.addOrder(order);

            if (orderService.showOrder(user).contains(order)) {
                logger.info("Order:  " + "ID: " + order.getOrderId() + "\t" + product.getArticle() + "\t" + product.getName() + "  - Successfully added\n");
            }
        }
        else {
            logger.info("Login to continue");
        }
    }

    public void showOrder(User user) throws DAOException {
        if (user.isUserSession()) {
            List<Order> orderList = orderService.showOrder(user);
            if (orderList.size() != 0) {
                logger.info(" - My Orders -\n");
                for (var order : orderList) {
                    logger.info("Order id: " + order.getOrderId());
                    logger.info("Article: " + order.getProduct().getArticle());
                    logger.info("Name: " + order.getProduct().getName());
                    logger.info("Supplier name: " + order.getProduct().getSupplierName());
                    logger.info("Quantity: " + order.getOrderQuantity());
                    logger.info("Total Price(BYN): " + order.getOrderTotal());
                    logger.info("Status: Ordered\n");
                }
            }
            else {
                logger.info("You have not made any order yet\n");
            }
        }
        else {
            logger.info("Login to continue");
        }
    }

    public void orderedProductDetail(User user, int orderId) throws DAOException {
        if (user.isUserSession()) {
            Order order = orderService.searchOrder(orderId);
            Product product = productService.productById(order.getProduct().getProductId());
            logger.info(" - Order Details -");
            System.out.println("Order id: " + orderId + "\nArticle: " + product.getArticle() + "\nName: " + product.getName() +
                    "\nSupplier name: " + product.getSupplierName() + "\nQuantity: " + order.getOrderQuantity() + "\nTotal Price(BYN): " +
                    order.getOrderTotal() + "Order status: " + order.getOrderStatus().getOrderStatusType());
            logger.info("1. Change status\n2. Back\nEnter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
            }

        }
        else {
            logger.info("Login to continue");
        }
    }
}
