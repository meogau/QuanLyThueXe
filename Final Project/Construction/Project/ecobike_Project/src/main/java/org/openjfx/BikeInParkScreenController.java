package org.openjfx;

import controller.BikeController;
import controller.BikeParkingController;
import dataAccess.entities.Bike;
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

    // private AnchorPane mainPane;

    ObservableList<OneBikeScreenController> oneBikeControllers;
    @FXML
    private GridPane gridPane;
    public BikeInParkScreenController() {
        oneBikeControllers = FXCollections.observableArrayList();
        gridPane = new GridPane();

    }
//    public void setMainPane(AnchorPane mainPane) {
//        this.mainPane = mainPane;
//    }
    public void initData(int bikeParkingId) throws SQLException {
        List<Bike> listBikes = bikeController.getListBike(bikeParkingId);
        int index =0;
        for(Bike bike:listBikes){
            System.out.println(bike.toString());
        }
        while( index<3) {
            loadAndSetBikeForOnePark(listBikes.get(index), 0, index);
            index++;
        }
        while( index<5) {
            loadAndSetBikeForOnePark(listBikes.get(index), 1, index-3);
            index++;
        }
    }

    private void loadAndSetBikeForOnePark(Bike bike, int rowIndex, int colIndex) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OneBike.fxml"));
        HBox box = new HBox();
        try {
            box = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((OneBikeScreenController) loader.getController()).setBikeInfo(bike);
        ((OneBikeScreenController) loader.getController()).setMainPane(getMainPane());
        gridPane.add(box, colIndex, rowIndex);

    }

    public void initialize(int bikeParkingId) throws SQLException {

    }
}
