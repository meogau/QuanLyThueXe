package org.openjfx;

import dataAccess.entities.Bike;
import dataAccess.entities.Parking;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class OneBikeScreenController extends AbstractNode{
    // private AnchorPane mainPane;
//    public void setMainPane(AnchorPane mainPane) {
//        this.mainPane = mainPane;
//    }
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
    
    private int bikeId;

    private Bike bike;
    public OneBikeScreenController() {
    	
        System.out.println("Vao one Bike controller");
        parkName = new Label();
        parkID = new Label();
        numOfBikes = new Label();
        address = new Label();
        status = new Label();
        image = new ImageView();
        
    }
    public void setBikeInfo(Bike bike) {
        this.bike = bike;
        this.bikeId = bike.getId();
        parkName.setText(bike.getName());
        // parkID.setText(String.valueOf(bike.getId()));
        numOfBikes.setText(String.valueOf(bike.getBikeCode()));
        address.setText(String.valueOf(bike.getBattery()));
        status.setText((bike.getStatus() > 0)?"đã cho thuê": "sẵn sàng");
        image.setImage(new Image(bike.getImage()));
        
    }

    public void viewBike() throws IOException {
    	FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "ViewBike.fxml"
                )
        );
        
        FXMLLoader headerLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
        AnchorPane headerPane = headerLoader.load();

        AnchorPane parentPane = loader.load();

        ViewBikeController controller =
                loader.<ViewBikeController>getController();
        controller.initData(this.bike);   
        controller.setMainPane(getMainPane());
        ((HeaderController) headerLoader.getController()).setMainPane(getMainPane());
        
        getMainPane().getChildren().clear();
        getMainPane().getChildren().add(headerPane);
        headerPane.setLayoutY(0);
        getMainPane().getChildren().add(parentPane);
        parentPane.setLayoutY(100);
    }

}
