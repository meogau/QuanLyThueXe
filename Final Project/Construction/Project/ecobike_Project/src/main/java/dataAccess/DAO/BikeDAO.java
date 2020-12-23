package dataAccess.DAO;

import dataAccess.entities.Bike;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BikeDAO extends BaseDAO {
    private static DBConnection connect = new DBConnection();
    private static Connection connection = (Connection) connect.getConnection();

    public List<Bike> getListBike(int bikeParkingId) throws SQLException {
        String sql = "select * from Bike where ParkingId = "+bikeParkingId;
        List<Bike> listBike = new ArrayList<>();

            ResultSet rs = getResultSet(sql);
            while (rs.next()) {
                Bike bike = new Bike();
                bike.setId(rs.getInt("Id"));
                bike.setBikeParkingId(rs.getInt("ParkingId"));
                bike.setBattery(rs.getFloat("Battery"));
                bike.setName(rs.getString("Name"));
                bike.setStatus(rs.getInt("Status"));
                bike.setDescription(rs.getString("Description"));
                bike.setImage(rs.getString("Image"));
                bike.setType(rs.getInt("Type"));
                bike.setPrice(rs.getFloat("Value"));
                bike.setBikeCode(rs.getString("BikeCode"));

                listBike.add(bike);

            }


        return listBike;
    }
    public Bike getBikeById(int bikeId){
        Bike bike = new Bike();
        String sql = "select * from Bike where Id = "+bikeId;
        try {
            ResultSet rs = getResultSet(sql);
            while(rs.next()){
                bike.setId(bikeId);
                bike.setBikeParkingId(rs.getInt("ParkingId"));
                bike.setBattery(rs.getFloat("Battery"));
                bike.setName(rs.getString("Name"));
                bike.setStatus(rs.getInt("Status"));
                bike.setDescription(rs.getString("Description"));
                bike.setImage(rs.getString("Image"));
                bike.setType(rs.getInt("Type"));
                bike.setPrice(rs.getFloat("Value"));
                bike.setBikeCode(rs.getString("BikeCode"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bike;
    }

    public void updateStatus(int bikeId, int status){
        String query = "update Bike set Status = ? where id = ?";
        try{
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt   (1, status);
            preparedStmt.setInt(2, bikeId);
            preparedStmt.executeUpdate();
        }
        catch (Exception e){

        }

    }

    public int getBikeStatus(int bikeId){
        int status =0;
        String sql = "select Status from Bike where Id = "+bikeId;
        try {
            ResultSet rs = getResultSet(sql);
            while (rs.next()) {
                status = rs.getInt("Status");
            }
        }
        catch (Exception e){

        }
        return status;
    }

    public Bike findBikeByBikeCode(String bikeCode) throws SQLException {

        Bike bike = new Bike();
        String sql = "select * from Bike where bikeCode = '"+bikeCode+"'";
        ResultSet rs = getResultSet(sql);

        while (rs.next()) {
            bike.setId(rs.getInt("Id"));
            bike.setBikeParkingId(rs.getInt("ParkingId"));
            bike.setBattery(rs.getFloat("Battery"));
            bike.setName(rs.getString("Name"));
            bike.setStatus(rs.getInt("Status"));
            bike.setDescription(rs.getString("Description"));
            bike.setImage(rs.getString("Image"));
            bike.setType(rs.getInt("Type"));
            bike.setPrice(rs.getFloat("Value"));
            bike.setBikeCode(rs.getString("BikeCode"));

        }

        return bike;

    }
}
