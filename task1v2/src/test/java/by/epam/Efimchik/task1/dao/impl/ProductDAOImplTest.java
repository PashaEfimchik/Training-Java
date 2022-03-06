package by.epam.Efimchik.task1.dao.impl;

import by.epam.Efimchik.task1.dao.DAOException;
import by.epam.Efimchik.task1.entities.Product;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDAOImplTest extends TestCase {
    private ProductDAOImpl productDAO;
    private Product product;

    @Before
    public void setUp() throws Exception {
        productDAO = new ProductDAOImpl();
        product = new Product(111, "testArticle", "testName", "testSupplierName", 250);
    }

    @After
    public void tearDown() throws Exception {
        productDAO = null;
    }

    @Test
    public void testAdd() {
        productDAO.add(product);
        List<Product> productList = productDAO.allProducts().stream().distinct().collect(Collectors.toList());
        Assert.assertEquals(product.getName(), productList.get(5).getName());
    }

    @Test
    public void testUpdate() {
        try {
            productDAO.update(product, new String[]{String.valueOf(777), "newArticle", "newName", "newSupplierName", String.valueOf(400)});
        } catch (DAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("newName", product.getName());
    }

    @Test
    public void testProductById() {
        productDAO.add(product);

        Product testProduct = productDAO.productById(111);

        Assert.assertEquals(product.getProductId(), testProduct.getProductId());
        Assert.assertEquals(product.getArticle(), testProduct.getArticle());
        Assert.assertEquals(product.getName(), testProduct.getName());
        Assert.assertEquals(product.getSupplierName(), testProduct.getSupplierName());

    }

    @Test
    public void testAllProducts() {
        List<Product> productList = productDAO.allProducts().stream().distinct().collect(Collectors.toList());

        Assert.assertEquals(5, productList.size());
    }

    @Test
    public void testSearch() {
        productDAO.add(product);

        List<Product> searchProduct = productDAO.search(product.getArticle());
        for (var prod : searchProduct) {
            Assert.assertEquals(product.getProductId(), prod.getProductId());
            Assert.assertEquals(product.getArticle(), prod.getArticle());
            Assert.assertEquals(product.getName(), prod.getName());
            Assert.assertEquals(product.getSupplierName(), prod.getSupplierName());
        }

    }

    public void testRemove() {
        Product product1 = new Product(222, "testArticle2", "testName2", "testSupplierName2", 350);
        productDAO.add(product1);
        productDAO.remove(222);

        List<Product> productList = productDAO.allProducts().stream().distinct().collect(Collectors.toList());

        Assert.assertEquals(6, productList.size());
    }
}