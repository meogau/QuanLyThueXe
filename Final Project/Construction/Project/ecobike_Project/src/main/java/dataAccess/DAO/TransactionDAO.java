package dataAccess.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionDAO {
    private static DBConnection connect = new DBConnection();
    private static Connection connection = (Connection) connect.getConnection();



     public int  saveTransaction(int cardId, BigDecimal amount, String command ){
         int transactionId = 0;

         String query = " insert into Transaction ( CardId, Amount,command )"
                 + " values ( ?, ?,?)";
         try{
             PreparedStatement preparedStmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
             preparedStmt.setInt(1, cardId);
             preparedStmt.setFloat(2, amount.floatValue());
             preparedStmt.setString(3,command);

             preparedStmt.execute();
             ResultSet rs = preparedStmt.getGeneratedKeys();
             if (rs.next()){
                 transactionId=rs.getInt(1);
             }
         }
         catch (Exception e){

         }

         return transactionId;
     }

}
