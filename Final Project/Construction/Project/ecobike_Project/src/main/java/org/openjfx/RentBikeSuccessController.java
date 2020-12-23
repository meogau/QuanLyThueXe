package org.openjfx;

import java.io.IOException;

import DTO.RentalInformation;
import controller.RentBikeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RentBikeSuccessController extends AbstractNode {
	private int rentalID;
	public void setRentalID(int rentalID) {
		this.rentalID = rentalID;
	}
	
	RentBikeController rentcontroller = new RentBikeController();
	
	@FXML
	private void backToHome() throws Exception{
		FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        AnchorPane homePane = new AnchorPane();
        FXMLLoader headerLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
        AnchorPane headerPane = new AnchorPane();
        try {
            homePane = homeLoader.load();
            headerPane = headerLoader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        ((HomeController) homeLoader.getController()).setMainPane(getMainPane());
        ((HeaderController) headerLoader.getController()).setMainPane(getMainPane());
        getMainPane().getChildren().clear();
        getMainPane().getChildren().add(headerPane);
        getMainPane().getChildren().add(homePane);
        headerPane.setLayoutY(0);
        homePane.setLayoutY(100);
        getMainPane().getScene().getWindow().setWidth(1000);
        getMainPane().getScene().getWindow().setHeight(650);
	}
	
	@FXML
	private void goToRentingBike() throws Exception{
		FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "ViewBike.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );
        

       

        ViewBikeController controller =
                loader.<ViewBikeController>getController();
        controller.initData(rentcontroller.getBikeRental(rentalID));   
        stage.show();
        
        

        
	}
	
	@FXML
	private void returnBike() throws IOException {
		RentalInformation rentalInfo = rentcontroller.returnBike(rentalID);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ReturnBikeSuccess.fxml"));
		AnchorPane pane = loader.load();
		((ReturnBikeSuccessController) loader.getController()).setMainPane(getMainPane());
		((ReturnBikeSuccessController) loader.getController()).setRental(rentalInfo);
		((ReturnBikeSuccessController) loader.getController()).initData();
		getMainPane().getChildren().clear();
		getMainPane().getChildren().add(pane);
        getMainPane().getScene().getWindow().setWidth(1000);
        getMainPane().getScene().getWindow().setHeight(650);
	}
}
