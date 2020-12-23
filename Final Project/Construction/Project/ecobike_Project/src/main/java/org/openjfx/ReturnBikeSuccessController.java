package org.openjfx;

import java.io.IOException;

import DTO.RentalInformation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ReturnBikeSuccessController extends AbstractNode{
	
	@FXML
	private Label bikeName;
	@FXML
	private Label rentTime;
	@FXML
	private Label amount;
	@FXML
	private Label deposit;
	@FXML
	private Label changeMoney;
	
	private RentalInformation rental;
	public void setRental(RentalInformation rental) {
		this.rental = rental;
	}
	
	public void initData() {
		bikeName.setText(rental.getBikeName());
		rentTime.setText(String.valueOf(rental.getUsingTime()));
		amount.setText(String.valueOf(rental.getRentalFee()));
		deposit.setText(String.valueOf(rental.getDeposit()));
		changeMoney.setText(String.valueOf(rental.getDeposit().floatValue()-rental.getRentalFee().floatValue()));
	}
	
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
	
}
