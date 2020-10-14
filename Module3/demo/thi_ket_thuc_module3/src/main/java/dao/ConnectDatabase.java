package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private static final String jdbcURL="jdbc:mysql://localhost:3306/product_manager";
    private static final String jdbcUserName="root";
    private static final String jdbcPassword="hoquynhmai";

    public static Connection getConnect(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }
}
