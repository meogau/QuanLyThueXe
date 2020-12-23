package dataAccess.DAO;


import dataAccess.entities.Bike;
import dataAccess.entities.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CardDAO extends BaseDAO {
    private static DBConnection connect = new DBConnection();
    private static Connection connection = (Connection) connect.getConnection();



    public int createCard(String cardNumber, String cardHolder, String expirationDate, String securityCode){
        int cardId = 0;

        String query = " insert into Card ( cardNumber, cardHolder, expirationDate, securityCode)"
                + " values ( ?, ?, ?, ?)";
        try{
            PreparedStatement preparedStmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, cardNumber);
            preparedStmt.setString   (2, cardHolder);
            preparedStmt.setString(3, expirationDate);
            preparedStmt.setString    (4, securityCode);
            preparedStmt.executeUpdate();
            ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()){
                cardId=rs.getInt(1);
            }
        }
        catch (Exception e){
        }
        return cardId;
    }

    public Card findCardById(int id){
        Card card = new Card();
        String sql = "select * from Card where Id = "+id;
        try {
            ResultSet rs = getResultSet(sql);
            while(rs.next()){
              card.setId(id);
              card.setExpirationDate(rs.getString("ExpirationDate"));
              card.setCardNumber(rs.getString("CardNumber"));
              card.setCardHolder(rs.getString("CardHolder"));
              card.setSecurityCode(rs.getString("SecurityCode"));
              card.setStatus(rs.getInt("status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return card;
    }

    public Card findCardByCardNumber(String cardNumber){
        Card card = new Card();
        String sql = "select * from Card where CardNumber = '"+cardNumber+"'";
        try {
            ResultSet rs = getResultSet(sql);
            while(rs.next()){
                card.setId(rs.getInt("id"));
                card.setExpirationDate(rs.getString("ExpirationDate"));
                card.setCardNumber(rs.getString("CardNumber"));
                card.setCardHolder(rs.getString("CardHolder"));
                card.setSecurityCode(rs.getString("SecurityCode"));
                card.setStatus(rs.getInt("status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return card;
    }

    public void updateCardStatus(String cardNumber, int status){
        String query = "update Card set Status = ? where CardNumber = ?";
        try{
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt   (1, status);
            preparedStmt.setString(2, cardNumber);
            preparedStmt.executeUpdate();
        }
        catch (Exception e){

        }
    }

    public boolean checkCardExist(String cardNumber){
        String sql = "select * from Card where cardnumber = '"+cardNumber+"'";
        boolean status = false;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(st.toString());
            while (rs.next()){
                status=true;
            }
        }
        catch (Exception e){
        }
        return status;
    }
    public int checkCardStatus(String cardNumber){
        String sql = "select status from Card where cardnumber = '"+cardNumber+"'";
        int status =0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                status=rs.getInt("status");
            }
        }
        catch (Exception e){
        }
         return status;

    }

}
