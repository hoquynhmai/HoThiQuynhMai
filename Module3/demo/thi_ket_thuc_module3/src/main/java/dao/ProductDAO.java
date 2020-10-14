package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAllProduct();
    List<Product> findProductByPrice(String productPrice);
    String create(Product product);
    String edit(Product product);
    List<Product> findProductByName(String productName);
    void delete(String productId);
    List<Product> findProductByNameAndPrice(String productName,String productPrice);
}
