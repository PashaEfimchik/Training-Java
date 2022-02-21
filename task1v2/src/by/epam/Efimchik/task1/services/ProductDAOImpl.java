package by.epam.Efimchik.task1.services;

import by.epam.Efimchik.task1.dao.ProductDAO;
import by.epam.Efimchik.task1.dao.ProductDAOException;
import by.epam.Efimchik.task1.entities.Product;
import by.epam.Efimchik.task1.entities.User;
import by.epam.Efimchik.task1.utils.InitializationUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductDAOImpl implements ProductDAO <Product> {
    private static List<Product> productList = new ArrayList<>();

    public ProductDAOImpl(){
        InitializationUtil initializationUtil = new InitializationUtil();
        initializationUtil.uploadProducts(productList);
    }

    @Override
    public void add(Product p){
        productList.add(p);
    }

    @Override
    public void update(Product product, String[] params) throws ProductDAOException {
        product.setId(Integer.valueOf(Objects.requireNonNull(params[0])));
        product.setArticle(Objects.requireNonNull(params[1]));
        product.setName(Objects.requireNonNull(params[2]));
        product.setSupplierName(Objects.requireNonNull(params[3]));
        product.setQuantity(Integer.valueOf(Objects.requireNonNull(params[4])));
        product.setPrice(Float.valueOf(Objects.requireNonNull(params[5])));
    }

    @Override
    public Product productById (int id) {
        for(Product product : productList) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> allProducts () {
        return productList;
    }

    @Override
    public List<Product> search (String par) {
        List<Product> searchProductList = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(par) || p.getArticle().contains(par) || p.getSupplierName().contains(par)){
                searchProductList.add(p);
            }
        }
        return searchProductList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public void remove (int id) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()){
            Product product = iterator.next();
            if (product.getId() == id){
                iterator.remove();
            }
        }
    }
}