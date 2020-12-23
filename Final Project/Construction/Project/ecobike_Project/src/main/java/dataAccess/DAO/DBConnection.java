package dataAccess.DAO;
import API.Config;

import java.sql.*;

public class DBConnection {


    public  Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Config.DB_URL, Config.USER_NAME, Config.PASSWORD);
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
