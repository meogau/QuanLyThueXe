package controller;

import dataAccess.DAO.BikeDAO;
import dataAccess.DAO.RentalDAO;
import dataAccess.entities.Bike;
import dataAccess.entities.ElectricBike;
import dataAccess.entities.StandBike;

import java.sql.SQLException;
import java.util.List;

public class BikeController {
    private static BikeDAO bikeDAO = new BikeDAO();
    private static RentalDAO rentalDAO = new RentalDAO();

    public List<StandBike> getListStandBike(int bikeParkingId) throws SQLException {
        return bikeDAO.getListStandBike(bikeParkingId);
    }
    public List<ElectricBike> getListElectricBike(int bikeParkingId) throws SQLException {
        return bikeDAO.getListElectricBike(bikeParkingId);
    }

    public Bike findBikeByBikeCode(String bikeCode) throws SQLException {
        return bikeDAO.findBikeByBikeCode(bikeCode);
    }



}
