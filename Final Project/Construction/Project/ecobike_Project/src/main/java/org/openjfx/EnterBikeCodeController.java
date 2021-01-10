package org.openjfx;

import controller.BikeController;
import dataAccess.entities.Bike;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EnterBikeCodeController extends AbstractNode{
    @FXML
    private TextField inputCode;
    private  BikeController bikeController = new BikeController();
    
    public EnterBikeCodeController() {
    	inputCode = new TextField();
    }
    
    @FXML
    private void findBike() throws Exception{
//    	Bike bike = bikeController.findBikeByBikeCode(inputCode.getText());
//    	System.out.println(bike.toString());
//
//    	FXMLLoader loader = new FXMLLoader(
//                getClass().getResource(
//                        "ViewBike.fxml"
//                )
//        );
//
//        FXMLLoader headerLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
//        AnchorPane headerPane = headerLoader.load();
//
//        AnchorPane parentPane = loader.load();
//
//        ViewBikeController controller =
//                loader.<ViewBikeController>getController();
//        controller.initData(bike);
//        controller.setMainPane(getMainPane());
//        ((HeaderController) headerLoader.getController()).setMainPane(getMainPane());
//
//        getMainPane().getChildren().clear();
//        getMainPane().getChildren().add(headerPane);
//        headerPane.setLayoutY(0);
//        getMainPane().getChildren().add(parentPane);
//        parentPane.setLayoutY(100);
//        getMainPane().getScene().getWindow().setHeight(650);
//        getMainPane().getScene().getWindow().setWidth(1000);
    }
   
    
}
