package com.company.utils;

import com.company.entities.Product;
import com.company.entities.User;
import com.company.services.UserDAOImpl;

import java.util.List;

public class InitializationUtil {
    public void uploadUsers(List<User> listUser) {
        listUser.add(new User(1, "email@gmail.com", "username1", "password1"));
        listUser.add(new User(2, "email@vk.com", "username2", "password2"));
        listUser.add(new User(3, "email@example.com", "username3", "password3"));
        listUser.add(new User(4, "email@yandex.ru", "username4", "password4"));
        listUser.add(new User(5, "email@mail.ru", "username5", "password5"));
    }

    public void uploadProducts(List<Product> listProduct) {
        listProduct.add(new Product(11, 15, "auto1.by", "Air filter", "MANN-FILTER C 2245", 30));
        listProduct.add(new Product(12, 7, "armtek", "Catalyst", "ASSO 04.0019", 399));
        listProduct.add(new Product(21, 20, "autoostrov.by", "Clutch kit", "STELLOX 07-01055-SX", 115));
        listProduct.add(new Product(33, 4, "pitavto.by", "Battery", "BOSCH MOBA FP M4F 12V 18 AH 200A R+", 170));
        listProduct.add(new Product(57, 13, "mg.by", "Motor oil", "Motul 7100 4T 10W-40 4L", 154));
    }
}
