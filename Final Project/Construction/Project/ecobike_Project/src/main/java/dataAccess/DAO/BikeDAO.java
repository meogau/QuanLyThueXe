package dataAccess.DAO;

import dataAccess.entities.Bike;
import dataAccess.entities.ElectricBike;
import dataAccess.entities.StandBike;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BikeDAO extends BaseDAO {
    private static DBConnection connect = new DBConnection();
    private static Connection connection = (Connection) connect.getConnection();

    public List<StandBike> getListStandBike(int bikeParkingId) throws SQLException {
        String sql = "select * from StandBike where ParkingId = "+bikeParkingId;
        List<StandBike> listBike = new ArrayList<>();
            ResultSet rs = getResultSet(sql);
            while (rs.next()) {
                StandBike bike = new StandBike();
                bike.setId(rs.getInt("Id"));
                bike.setBikeParkingId(rs.getInt("ParkingId"));
                bike.setName(rs.getString("Name"));
                bike.setStatus(rs.getInt("Status"));
                bike.setDescription(rs.getString("Description"));
                bike.setImage(rs.getString("Image"));
                bike.setPrice(rs.getFloat("Value"));
                bike.setBikeCode(rs.getString("BikeCode"));
                listBike.add(bike);
            }
        return listBike;
    }
    public List<ElectricBike> getListElectricBike(int bikeParkingId) throws SQLException {
        String sql = "select * from ElectricBike where ParkingId = "+bikeParkingId;
        List<ElectricBike> listBike = new ArrayList<>();
        ResultSet rs = getResultSet(sql);
        while (rs.next()) {
            ElectricBike bike = new ElectricBike();
            bike.setId(rs.getInt("Id"));
            bike.setBikeParkingId(rs.getInt("ParkingId"));
            bike.setName(rs.getString("Name"));
            bike.setStatus(rs.getInt("Status"));
            bike.setDescription(rs.getString("Description"));
            bike.setImage(rs.getString("Image"));
            bike.setPrice(rs.getFloat("Value"));
            bike.setBikeCode(rs.getString("BikeCode"));
            bike.setBattery(rs.getFloat("Battery"));
            listBike.add(bike);
        }
        return listBike;
    }

    public void updateStatusElectricBike(int bikeId, int status){
        String query = "update ElectricBike set Status = ? where id = ?";
        try{
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt   (1, status);
            preparedStmt.setInt(2, bikeId);
            preparedStmt.executeUpdate();
        }
        catch (Exception e){

        }

    }

    public void updateBikeStatus(Bike bike, int status){
        if(bike instanceof ElectricBike) updateStatusElectricBike(bike.getId(),status);
        else updateStatusStandBike(bike.getId(),status);
    }

    public void updateStatusStandBike(int bikeId, int status){
        String query = "update StandBike set Status = ? where id = ?";
        try{
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt   (1, status);
            preparedStmt.setInt(2, bikeId);
            preparedStmt.executeUpdate();
        }
        catch (Exception e){

        }

    }


    public Bike findBikeByBikeCode(String bikeCode) throws SQLException {

        StandBike standBike = new StandBike();
        
        String sql = "select * from Bike where bikeCode = '"+bikeCode+"'";
        ResultSet rs = getResultSet(sql);

        while (rs.next()) {
            standBike.setId(rs.getInt("Id"));
            standBike.setBikeParkingId(rs.getInt("ParkingId"));
            standBike.setName(rs.getString("Name"));
            standBike.setStatus(rs.getInt("Status"));
            standBike.setDescription(rs.getString("Description"));
            standBike.setImage(rs.getString("Image"));
            standBike.setPrice(rs.getFloat("Value"));
            standBike.setBikeCode(rs.getString("BikeCode"));

        }
        String sql2 = "select * from ElectricBike where bikeCode = '"+bikeCode+"'";
        ResultSet rs2 = getResultSet(sql2);
        ElectricBike electricBike = new ElectricBike();
        while (rs2.next()) {
            electricBike.setId(rs2.getInt("Id"));
            electricBike.setBikeParkingId(rs2.getInt("ParkingId"));
            electricBike.setName(rs2.getString("Name"));
            electricBike.setStatus(rs2.getInt("Status"));
            electricBike.setDescription(rs2.getString("Description"));
            electricBike.setImage(rs2.getString("Image"));
            electricBike.setPrice(rs2.getFloat("Value"));
            electricBike.setBikeCode(rs2.getString("BikeCode"));
            electricBike.setBattery(rs2.getFloat("Battery"));

        }
        if(standBike.getName().equals(null)) return electricBike;
        return standBike;

    }
    public Bike findBikeById(int  id) throws SQLException {

        StandBike standBike = new StandBike();

        String sql = "select * from Bike where id = "+id;
        ResultSet rs = getResultSet(sql);

        if(!rs.equals(null)) {
            standBike.setId(rs.getInt("Id"));
            standBike.setBikeParkingId(rs.getInt("ParkingId"));
            standBike.setName(rs.getString("Name"));
            standBike.setStatus(rs.getInt("Status"));
            standBike.setDescription(rs.getString("Description"));
            standBike.setImage(rs.getString("Image"));
            standBike.setPrice(rs.getFloat("Value"));
            standBike.setBikeCode(rs.getString("BikeCode"));
            return standBike;
        }

        String sql2 = "select * from ElectricBike where id = "+id;
        ResultSet rs2 = getResultSet(sql2);
        ElectricBike electricBike = new ElectricBike();
        while (rs2.next()) {
            electricBike.setId(rs2.getInt("Id"));
            electricBike.setBikeParkingId(rs2.getInt("ParkingId"));
            electricBike.setName(rs2.getString("Name"));
            electricBike.setStatus(rs2.getInt("Status"));
            electricBike.setDescription(rs2.getString("Description"));
            electricBike.setImage(rs2.getString("Image"));
            electricBike.setPrice(rs2.getFloat("Value"));
            electricBike.setBikeCode(rs2.getString("BikeCode"));
            electricBike.setBattery(rs2.getFloat("Battery"));

        }
       return electricBike;


    }
}
