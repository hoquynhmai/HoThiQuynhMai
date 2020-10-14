package bo;

import common.ValidateProduct;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO {
    ProductDAO productDAO=new ProductDAOImpl();
    @Override
    public List<Product> findAllProduct() {
        return this.productDAO.findAllProduct();
    }

    @Override
    public List<Product> findProductByName(String productName) {
        return this.productDAO.findProductByName(productName);
    }

    @Override
    public String create(Product product) {
        String message=null;
        boolean checkName= product.getProductName().equals("");
        boolean checkPriceIsNull= product.getPrice().equals("");
        boolean checkQuantityIsNull= product.getQuantity().equals("");
        if (checkName){
            message="Product Name not null";
        }else if (checkPriceIsNull){
            message="Price not null";
        }else if (!ValidateProduct.checkPositiveNumber(product.getPrice()) || !(Integer.parseInt(product.getPrice()) > 10000000)){
            message="Price is number and > 10000000";
        }else if (checkQuantityIsNull){
            message="Quantity not null";
        }else if (!ValidateProduct.checkPositiveInteger(product.getQuantity())){
            message="Quantity is number positive integer";
        }
            else message=this.productDAO.create(product);
        return message;
    }

    @Override
    public String edit(Product product) {
        return this.productDAO.edit(product);
    }

    @Override
    public void delete(String productId) {
        this.productDAO.delete(productId);
    }

    @Override
    public List<Product> findProductByNameAndPrice(String productName, String productPrice) {
        return this.productDAO.findProductByNameAndPrice(productName,productPrice);
    }

    @Override
    public List<Product> findProductByPrice(String productPrice) {
        return this.productDAO.findProductByPrice(productPrice);
    }
}
