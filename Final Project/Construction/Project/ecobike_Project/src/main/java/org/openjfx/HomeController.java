package org.openjfx;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class HomeController extends AbstractNode{


    public HomeController() throws Exception {
    }


    @FXML
    private void goToViewListBike() throws IOException {
        FXMLLoader bikeParkLoader = new FXMLLoader(getClass().getResource("BikeParks2.fxml"));
        FXMLLoader headerLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
        AnchorPane bikeParkPane = bikeParkLoader.load();
        AnchorPane headerPane = headerLoader.load();
        // System.out.println(mainPane == null);
        ((ParkingScreenController) bikeParkLoader.getController()).setMainPane(getMainPane());
        ((ParkingScreenController) bikeParkLoader.getController()).init();
        ((HeaderController) headerLoader.getController()).setMainPane(getMainPane());
        getMainPane().getChildren().clear();
        // System.out.println(getMainPane().getChildren().size());
        getMainPane().getChildren().add(headerPane);
        headerPane.setLayoutY(0);
        getMainPane().getChildren().add(bikeParkPane);
        bikeParkPane.setLayoutY(100);
    }


    @FXML
    private void handleGoToEnterBikeCode() throws IOException {
        FXMLLoader enterBikeCodeLoader = new FXMLLoader(getClass().getResource("EnterBikeCode.fxml"));
        AnchorPane enterBikeCode = enterBikeCodeLoader.load();
        ((EnterBikeCodeController) enterBikeCodeLoader.getController()).setMainPane(getMainPane());
        getMainPane().getChildren().clear();

        getMainPane().getChildren().add(enterBikeCode);
        enterBikeCode.setLayoutY(0);
    }

}
