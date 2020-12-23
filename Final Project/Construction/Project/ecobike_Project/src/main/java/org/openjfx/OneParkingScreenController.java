package org.openjfx;

import dataAccess.entities.Parking;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class OneParkingScreenController extends AbstractNode {
    private Parking park;
    @FXML
    private Label parkName;
    @FXML
    private Label parkID;
    @FXML
    private Label numOfBikes;
    @FXML
    private Label address;
    @FXML
    private Label status;
    @FXML
    private ImageView image;
    private int bikeParkingID;

//    private AnchorPane mainPane;
//
//    public void setMainPane(AnchorPane mainPane) {
//        this.mainPane = mainPane;
//    }

    public OneParkingScreenController() {
        parkName = new Label();
        parkID = new Label();
        numOfBikes = new Label();
        address = new Label();
        image = new ImageView();
        status = new Label();
    }

    public void setParkInfo(Parking park) {
        this.bikeParkingID = park.getiD();
        parkName.setText(park.getName());
        parkID.setText(String.valueOf(park.getiD()));
        numOfBikes.setText(String.valueOf(park.getCapacity()));
        address.setText(park.getAddress());
        status.setText(String.valueOf(park.getiD()));
        image.setImage(new Image(park.getImage()));
    }

    public int getBikeParkingID() {
        return bikeParkingID;
    }

    public void viewBikeInParking() throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "BikesInPark.fxml"
                )
        );

        AnchorPane bikesinParkPane = loader.load();
        FXMLLoader headerLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
        AnchorPane headerPane = headerLoader.load();

        BikeInParkScreenController controller =
                loader.<BikeInParkScreenController>getController();

        controller.setMainPane(getMainPane());
        ((HeaderController) headerLoader.getController()).setMainPane(getMainPane());
        controller.initData(this.bikeParkingID);


        getMainPane().getChildren().clear();
        getMainPane().getChildren().add(headerPane);
        headerPane.setLayoutY(0);
        getMainPane().getChildren().add(bikesinParkPane);
        bikesinParkPane.setLayoutY(100);

    }
}
