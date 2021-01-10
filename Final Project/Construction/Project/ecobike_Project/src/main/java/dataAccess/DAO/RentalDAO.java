package dataAccess.DAO;

import dataAccess.entities.Rental;

import java.sql.*;
import java.util.Calendar;

public class RentalDAO extends BaseDAO{
    private static DBConnection connect = new DBConnection();
    private static Connection connection = (Connection) connect.getConnection();



    public boolean endRentalBike(int rentailId){
        String query = "update Rental set EndTime = ? where id = ?";
        Timestamp endDate = new Timestamp(System.currentTimeMillis());
        try{
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setTimestamp(1, endDate);
            preparedStmt.setInt(2, rentailId);
            preparedStmt.executeUpdate();
            return true;
        }
        catch (Exception e){
        	System.out.println("endRentalBike error");
        }
        return false;
    }

    public int createRental(int bikeId,int cardId){
        Calendar calendar = Calendar.getInstance();
        System.out.println(bikeId);
        Timestamp startDate = new Timestamp(System.currentTimeMillis());
        int bikeRentalId =0;
        String query = " insert into Rental ( BikeId, Status, StartTime,CardId)"
                + " values ( ?, ?, ?,?)";
        try{
            PreparedStatement preparedStmt = connection.prepareStatement(query ,Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, bikeId);
            preparedStmt.setInt(2, 1);
            preparedStmt.setTimestamp(3, startDate);
            System.out.println(bikeId);
            preparedStmt.setInt(4, cardId);
            preparedStmt.execute();
            ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()){
                bikeRentalId=rs.getInt(1);
            }
        }
        catch (Exception e){
        	e.printStackTrace();
        }
      return bikeRentalId;
    }

    public int getBikeId(int bikeRentalId){
        int id = 0;
        String sql = "select BikeId from Rental Where id ="+bikeRentalId;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                id = rs.getInt("1");
            }
        }
        catch (Exception e){
        }
        return id;

    }

    public Rental findRentalById(int id){
        Rental rental = new Rental();
        String sql = "select * from Rental Where id ="+id;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
               rental.setId(id);
               rental.setBikeId(rs.getInt("BikeId"));
               rental.setStartTime(rs.getTimestamp("StartTime"));
               rental.setEndTime(rs.getTimestamp("EndTime"));
               rental.setCardId(rs.getInt("cardId"));
            }
        }
        catch (Exception e){
        }
        return rental;


    }


}
