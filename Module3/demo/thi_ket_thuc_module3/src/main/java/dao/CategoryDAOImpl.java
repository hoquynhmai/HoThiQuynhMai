package dao;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private static final String SELECT_ALL_CATEGORY = "SELECT category_id,category_name " +
            "FROM category ";
    @Override
    public List<Category> findAllCategory() {
        List<Category> categoryList=new ArrayList<>();
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_CATEGORY)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String categoryId=resultSet.getString("category_id");
                String categoryName=resultSet.getString("category_name");
                categoryList.add(new Category(categoryId,categoryName));
                System.out.println();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }
}
