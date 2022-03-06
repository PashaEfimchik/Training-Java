package by.epam.Efimchik.task1.utils;

import by.epam.Efimchik.task1.entities.Product;
import by.epam.Efimchik.task1.entities.User;

import java.io.*;
import java.util.List;

public class InitializationUtil {

    public void unloadUsers() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.out"));

        objectOutputStream.writeObject(new User(1, "email@gmail.com", "username1", "password1", false));
        objectOutputStream.writeObject(new User(2, "email@vk.com", "username2", "password2", false));
        objectOutputStream.writeObject(new User(3, "email@example.com", "username3", "password3", false));
        objectOutputStream.writeObject(new User(4, "email@yandex.ru", "username4", "password4", false));
        objectOutputStream.writeObject(new User(5, "email@mail.ru", "username5", "password5", false));

        objectOutputStream.close();
    }

    public void unloadProducts() throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("product.out"));

        objectOutputStream.writeObject(new Product(11, "Air filter", "MANN-FILTER C 2245", "auto1.by", 30));
        objectOutputStream.writeObject(new Product(43, "Catalyst", "ASSO 04.0019", "armtek", 399));
        objectOutputStream.writeObject(new Product(54, "Clutch kit", "STELLOX 07-01055-SX", "autoostrov.by", 115));
        objectOutputStream.writeObject(new Product(76, "Battery", "BOSCH MOBA FP M4F 12V 18 AH 200A R+", "pitavto.by", 170));
        objectOutputStream.writeObject(new Product(52, "Motor oil", "Motul 7100 4T 10W-40 4L", "mg.by", 154));

        objectOutputStream.close();
    }
    public void uploadUsers(List<User> listUser) throws IOException, ClassNotFoundException {
        unloadUsers();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.out"));

        listUser.add((User) objectInputStream.readObject());
        listUser.add((User) objectInputStream.readObject());
        listUser.add((User) objectInputStream.readObject());
        listUser.add((User) objectInputStream.readObject());
        listUser.add((User) objectInputStream.readObject());

        objectInputStream.close();

        /*
        listUser.add(new User(1, "email@gmail.com", "username1", "password1", false));
        listUser.add(new User(2, "email@vk.com", "username2", "password2", false));
        listUser.add(new User(3, "email@example.com", "username3", "password3", false));
        listUser.add(new User(4, "email@yandex.ru", "username4", "password4", false));
        listUser.add(new User(5, "email@mail.ru", "username5", "password5", false));
        */
    }

    public void uploadProducts(List<Product> listProduct) throws IOException, ClassNotFoundException {
        unloadProducts();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("product.out"));

        listProduct.add((Product) objectInputStream.readObject());
        listProduct.add((Product) objectInputStream.readObject());
        listProduct.add((Product) objectInputStream.readObject());
        listProduct.add((Product) objectInputStream.readObject());
        listProduct.add((Product) objectInputStream.readObject());

        objectInputStream.close();

        /*listProduct.add(new Product(11, "Air filter", "MANN-FILTER C 2245", "auto1.by", 30));
        listProduct.add(new Product(43, "Catalyst", "ASSO 04.0019", "armtek", 399));
        listProduct.add(new Product(54, "Clutch kit", "STELLOX 07-01055-SX", "autoostrov.by", 115));
        listProduct.add(new Product(76, "Battery", "BOSCH MOBA FP M4F 12V 18 AH 200A R+", "pitavto.by", 170));
        listProduct.add(new Product(52, "Motor oil", "Motul 7100 4T 10W-40 4L", "mg.by", 154));*/
    }
}
