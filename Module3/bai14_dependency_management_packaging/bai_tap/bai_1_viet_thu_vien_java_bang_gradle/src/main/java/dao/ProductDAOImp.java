package dao;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductDAOImp implements ProductDAO {
    static Map<Integer, Product> productMap = new TreeMap<>();
    static {
        productMap.put(1,new Product(1,"iphone x", 10500,"Điện thoại","Apple"));
        productMap.put(2,new Product(2,"sam sung a51", 5100,"Điện thoại","Samsung"));
        productMap.put(3,new Product(3,"oppo f1", 6500,"Điện thoại","Oppo"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
