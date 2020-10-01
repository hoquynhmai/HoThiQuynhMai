package bo;

import dao.ProductDAO;
import dao.ProductDAOImp;
import model.Product;

import java.util.List;

public class ProductBOImp implements ProductBO {
    ProductDAO productDAO = new ProductDAOImp();

    @Override
    public List<Product> findAll() {
        return this.productDAO.findAll();
    }

    @Override
    public void save(Product product) {
        this.productDAO.save(product);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        this.productDAO.update(id,product);
    }

    @Override
    public void remove(int id) {
        this.productDAO.remove(id);
    }
}
