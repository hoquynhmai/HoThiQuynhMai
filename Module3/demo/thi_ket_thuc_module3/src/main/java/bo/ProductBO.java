package bo;

import model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAllProduct();
    List<Product> findProductByName(String productName);
    String create(Product product);
    String edit(Product product);
    void delete(String productId);
    List<Product> findProductByNameAndPrice(String productName,String productPrice);
    List<Product> findProductByPrice(String productPrice);
}
