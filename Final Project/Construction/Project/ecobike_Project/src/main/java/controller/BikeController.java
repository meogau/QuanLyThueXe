package controller;

import dataAccess.DAO.BikeDAO;
import dataAccess.DAO.RentalDAO;
import dataAccess.entities.Bike;

import java.sql.SQLException;
import java.util.List;

public class BikeController {
    private static BikeDAO bikeDAO = new BikeDAO();
    private static RentalDAO rentalDAO = new RentalDAO();

    public List<Bike> getListBike(int bikeParkingId) throws SQLException {
        return bikeDAO.getListBike(bikeParkingId);
    }

    public Bike findBikeByBikeCode(String bikeCode) throws SQLException {
        return bikeDAO.findBikeByBikeCode(bikeCode);
    }



}
