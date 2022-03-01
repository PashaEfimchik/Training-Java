package by.epam.Efimchik.task1.services;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.dao.impl.ProductDAOImpl;
import by.epam.Efimchik.task1.entities.Product;

import java.util.List;

public class ProductService {
    private ProductDAOImpl productDAO = new ProductDAOImpl();

    public void addProduct(Product Product) throws DAOException {
        productDAO.add(Product);
    }

    public List<Product> showAllProducts() throws DAOException {
        return productDAO.allProducts();
    }

    public void updateProduct(Product Product, String[] params) throws DAOException {
        productDAO.update(Product, params);
    }

    public Product productById(int id) throws DAOException {
        return productDAO.productById(id);
    }

    public List<Product> searchProduct(String param) throws DAOException {
        return productDAO.search(param);
    }

    public void removeProduct(int id) throws DAOException {
        productDAO.remove(id);
    }
}
