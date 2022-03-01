package by.epam.Efimchik.task1.controller;

import by.epam.Efimchik.task1.entities.CartItem;
import by.epam.Efimchik.task1.entities.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CartController extends Product {
    Scanner input = new Scanner(System.in);
    public List<CartItem> cartList = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        int index = -1;
        int currentQuantity = 0;
        for (var cartItem : cartList) {
            if (cartItem.equals(product)) {
                currentQuantity = cartItem.getQuantityItem();
                index = cartList.indexOf(cartItem);
            }
        }
        if (index != -1) {
            cartList.remove(cartList.get(index));
        }
        //cartList.add(new CartItem(product.getProductId(), currentQuantity + quantity, product.getSupplierName(), product.getArticle(), product.getName(), product.getPrice()));
    }

    public Integer getOverallCost() {
        int sum = 0;
        for (var cartItem : cartList) {
            sum += cartItem.getTotalPrice() * cartItem.getQuantityItem();
        }
        return sum;
    }

    public void removeCartItem() {
        System.out.println("Enter the cart item id to remove from the cart: ");
        int cartItemId = input.nextInt();

        Iterator<CartItem> iterator = cartList.iterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();
            if (cartItem.getId() == cartItemId) {
                iterator.remove();
            }
        }
    }

    public void showCart() {
        if (cartList != null) {
            for (var cartItem : cartList) {
                System.out.println("Article: " + cartItem.getProduct().getArticle() + "\nName: " + cartItem.getProduct().getName() + "\nSupplier name: " + cartItem.getProduct().getSupplierName() +
                        "\nPrice($): " + cartItem.getTotalPrice() + "\nQuantity: " + cartItem.getQuantityItem() + "\n");
            }
            System.out.println("Total purchase price: " + getOverallCost() + "\n");
        }
    }

    public void clearCart() {
        cartList.clear();
    }
}
