package org.openjfx;

import controller.BikeParkingController;
import dataAccess.entities.Parking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingScreenController extends AbstractNode{
    private BikeParkingController bikeParkingController = new BikeParkingController();

//    private AnchorPane mainPane;
//    public void setMainPane(AnchorPane mainPane) {
//        this.mainPane = mainPane;
//    }

    ArrayList<Parking> bikeParks;
    ObservableList<OneParkingScreenController> parkControllers;
    @FXML
    private GridPane gridPane;
    public ParkingScreenController() {
        System.out.println("ParkController is called");
        parkControllers = FXCollections.observableArrayList();
        gridPane = new GridPane();

    }

    public void init() {
        List<Parking> listParkings = bikeParkingController.getlistBikeParking();
        int index =0;
        while( index<3) {
            loadAndSetBikeForOnePark(listParkings.get(index), 0, index);
            index++;

        }
        while( index<5) {
            loadAndSetBikeForOnePark(listParkings.get(index), 1, index-3);
            index++;
        }

        /*
        * FXMLLoader loader = new FXMLLoader(getClass().getResource("OnePark.fxml"));
		HBox box = new HBox();
		try {
			box = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		((OneParkController) loader.getController()).setParkInfo(park)
        * */
    }

    private void loadAndSetBikeForOnePark(Parking park, int rowIndex, int colIndex) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OnePark.fxml"));
        HBox box = new HBox();
        try {
            box = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((OneParkingScreenController) loader.getController()).setParkInfo(park);
        ((OneParkingScreenController) loader.getController()).setMainPane(getMainPane());
        gridPane.add(box, colIndex, rowIndex);


    }

    public void initialize() {

    }
}
