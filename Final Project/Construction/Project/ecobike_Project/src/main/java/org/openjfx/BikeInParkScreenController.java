package org.openjfx;

import controller.BikeController;
import controller.BikeParkingController;
import dataAccess.entities.Bike;
import dataAccess.entities.ElectricBike;
import dataAccess.entities.StandBike;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BikeInParkScreenController extends AbstractNode{
    private BikeParkingController bikeParkingController = new BikeParkingController();
    private BikeController bikeController = new BikeController();


    ObservableList<OneStandBikeScreenController> oneBikeControllers;
    @FXML
    private GridPane gridPane;
    public BikeInParkScreenController() {
        oneBikeControllers = FXCollections.observableArrayList();
        gridPane = new GridPane();

    }

    public void initData(int bikeParkingId) throws SQLException {
        List<StandBike> listStandBikes = bikeController.getListStandBike(bikeParkingId);
        List<ElectricBike> listElecticBikes = bikeController.getListElectricBike(bikeParkingId);

        int index =0;
//        for(StandBike standBike:listStandBikes){
//            System.out.println(standBike.toString());
//        }
        while( index<3) {
            loadAndSetStandBike(listStandBikes.get(index), 0, index);
            index++;
        }
        while( index<6) {
            loadAndSetElectricBike(listElecticBikes.get(index-3), 1, index-3);
            index++;
        }
    }

    private void loadAndSetStandBike(StandBike bike, int rowIndex, int colIndex) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OneStandBike.fxml"));
        HBox box = new HBox();
        try {
            box = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((OneStandBikeScreenController) loader.getController()).setBikeInfo(bike);
        ((OneStandBikeScreenController) loader.getController()).setMainPane(getMainPane());
        gridPane.add(box, colIndex, rowIndex);

    }
    private void loadAndSetElectricBike(ElectricBike bike, int rowIndex, int colIndex) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OneElectricBike.fxml"));
        HBox box = new HBox();
        try {
            box = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((OneElectricBikeScreenController) loader.getController()).setBikeInfo(bike);
        ((OneElectricBikeScreenController) loader.getController()).setMainPane(getMainPane());
        gridPane.add(box, colIndex, rowIndex);

    }

    public void initialize(int bikeParkingId) throws SQLException {

    }
}
