package org.openjfx;

import controller.RentBikeController;
import dataAccess.entities.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PaymentScreenController extends AbstractNode {
	@FXML
	private TextField ownerCard;
	@FXML
	private TextField cardNumber;
	@FXML
	private TextField securityCode;
	@FXML
	private TextField expirationDate;

	private int bikeId;

	private RentBikeMessageController rentBikeMessageController = new RentBikeMessageController();

	private RentBikeController rentBikeController = new RentBikeController();

	public void handlePayment() throws IOException {

		Card card = new Card();
		card.setCardHolder(ownerCard.getText());
		card.setCardNumber(cardNumber.getText());
		card.setSecurityCode(securityCode.getText());
		card.setExpirationDate((expirationDate.getText()));
		System.out.println(bikeId);
		int rentalId = rentBikeController.rentBikeProcess(bikeId, card);
		if (rentalId > 0) {
			System.out.println("thue xe thanh cong");
			// show man hinh thue xe
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RentBike.fxml"));
			
			AnchorPane pane = loader.load();
			((RentBikeSuccessController) loader.getController()).setRentalID(rentalId);
			((RentBikeSuccessController) loader.getController()).setMainPane(getMainPane());
			getMainPane().getChildren().clear();
			getMainPane().getChildren().add(pane);
			getMainPane().getScene().getWindow().setWidth(1000);
			getMainPane().getScene().getWindow().setHeight(650);
		}

	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	@FXML
	private void backBtn() {
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
	}

	@FXML
	private void goToSuccessScreen() throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MessageForSuccessPayment.fxml"));
		AnchorPane pane = loader.load();
//        ((HomeController) homeLoader.getController()).setMainPane(getMainPane());
//        ((HeaderController) headerLoader.getController()).setMainPane(getMainPane());
		getMainPane().getChildren().clear();
		getMainPane().getChildren().add(pane);

	}
}
