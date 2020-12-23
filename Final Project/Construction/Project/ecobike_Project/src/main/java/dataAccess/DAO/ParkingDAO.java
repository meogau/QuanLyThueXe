package dataAccess.DAO;

import dataAccess.entities.Parking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParkingDAO extends BaseDAO {
    private static DBConnection connect = new DBConnection();
    private static Connection connection = (Connection) connect.getConnection();

    public List<Parking> getListBikeParking(){
        List<Parking> listParking = new ArrayList<>();
        String sql = "select * from Parking";
        try {
            ResultSet rs = getResultSet(sql);
            while (rs.next()) {
                Parking parking = new Parking();
                parking.setiD(rs.getInt("Id"));
                parking.setName(rs.getString("Name"));
                parking.setAddress(rs.getString("Address"));
                parking.setCapacity(rs.getInt("Capacity"));
                parking.setImage(rs.getString("Image"));
                listParking.add(parking);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listParking;
    }
    public List<Parking> seachListBikeParking(String key){
        List<Parking> listParking = new ArrayList<>();
        String sql = "select * from Parking where Name like %"+key +"%";
        try {
            ResultSet rs = getResultSet(sql);
            while (rs.next()) {
                Parking parking = new Parking();
                parking.setiD(rs.getInt("Id"));
                parking.setName(rs.getString("Name"));
                parking.setAddress(rs.getString("Address"));
                parking.setCapacity(rs.getInt("Capacity"));
                parking.setImage(rs.getString("Image"));
                listParking.add(parking);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listParking;
    }


}
