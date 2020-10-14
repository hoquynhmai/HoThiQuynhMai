package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static final String SELECT_ALL_PRODUCT = "SELECT product_id,product_name,price,quantity,color,`description`,category_id " +
            "FROM product ";
    private static final String CREATE = "INSERT INTO product(product_name,price,quantity,color,description,category_id) values (?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM product where product_id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM product where product_name LIKE ?";
    private static final String FIND_BY_PRICE = "SELECT * FROM product where price = ?";
    private static final String FIND_BY_NAME_AND_PRICE = "SELECT * FROM product where price = ? and product_name LIKE ?";
    @Override
    public List<Product> findAllProduct() {
        List<Product> productList=new ArrayList<>();
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_PRODUCT)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String productId=resultSet.getString("product_id");
                String productName=resultSet.getString("product_name");
                String price=String.format("%.0f",resultSet.getDouble("price"));
                String quantity=resultSet.getString("quantity");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                String categoryName=resultSet.getString("category_id");
                Product product=new Product(productId,productName,price,quantity,color,description,categoryName);
                productList.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> findProductByPrice(String productPrice) {
        List<Product> productList=new ArrayList<>();
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_PRICE)){
            preparedStatement.setString(1,productPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String productId=resultSet.getString("product_id");
                String productName=resultSet.getString("product_name");
                String price=String.format("%.0f",resultSet.getDouble("price"));
                String quantity=resultSet.getString("quantity");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                String categoryName=resultSet.getString("category_id");
                Product product=new Product(productId,productName,price,quantity,color,description,categoryName);
                productList.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }


    @Override
    public String create(Product product) {
        String message=null;
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(CREATE)){
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setString(2,product.getPrice());
            preparedStatement.setString(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setString(6,product.getCategoryId());
            preparedStatement.executeUpdate();
            message="OK";
        }catch (SQLException e){
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public String edit(Product product) {
        return null;
    }

    @Override
    public List<Product> findProductByName(String productName) {
        List<Product> productList=new ArrayList<>();
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_NAME)){
            preparedStatement.setString(1,"%"+productName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String productId=resultSet.getString("product_id");
                String productName1=resultSet.getString("product_name");
                String price=String.format("%.0f",resultSet.getDouble("price"));
                String quantity=resultSet.getString("quantity");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                String categoryName=resultSet.getString("category_id");
                Product product=new Product(productId,productName1,price,quantity,color,description,categoryName);
                productList.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;

    }

    @Override
    public void delete(String productId) {
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE)){
            preparedStatement.setString(1,productId);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> findProductByNameAndPrice(String productName, String productPrice) {
        List<Product> productList=new ArrayList<>();
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_NAME_AND_PRICE)){
            preparedStatement.setString(1,productPrice);
            preparedStatement.setString(2,"%"+productName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String productId=resultSet.getString("product_id");
                String productName1=resultSet.getString("product_name");
                String price=String.format("%.0f",resultSet.getDouble("price"));
                String quantity=resultSet.getString("quantity");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                String categoryName=resultSet.getString("category_id");
                Product product=new Product(productId,productName1,price,quantity,color,description,categoryName);
                productList.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }
}
