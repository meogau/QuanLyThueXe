package dataAccess.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDAO {
    public  ResultSet getResultSet(String sql){
          DBConnection connect = new DBConnection();
          Connection connection = (Connection) connect.getConnection();
        try {
            Statement stmt = (Statement) connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }
        catch (Exception e){
            return null;
        }
    }

}
