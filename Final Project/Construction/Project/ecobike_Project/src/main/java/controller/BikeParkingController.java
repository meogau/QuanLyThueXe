package controller;

import dataAccess.DAO.ParkingDAO;
import dataAccess.entities.Parking;

import java.util.List;

public class BikeParkingController {
    private static ParkingDAO parkingDAO = new ParkingDAO();
    public List<Parking> getlistBikeParking(){
        return parkingDAO.getListBikeParking();
    }
    public List<Parking> seachBikeParking(String key){
        return parkingDAO.seachListBikeParking(key);
    }
}
