package org.openjfx;

import dataAccess.entities.ElectricBike;
import dataAccess.entities.Parking;
import dataAccess.entities.StandBike;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class OneElectricBikeScreenController extends AbstractNode{

    private Parking park;

    @FXML
    private Label bikeCode;
    @FXML
    private Label status;
    @FXML
    private Label battery;
    @FXML
    private ImageView image;


    private ElectricBike electricBike;

    public OneElectricBikeScreenController() {
        battery = new Label();
        bikeCode = new Label();
        status = new Label();
        image = new ImageView();
        
    }
    public void setBikeInfo(ElectricBike electricBike) {
        this.electricBike = electricBike;
        bikeCode.setText(String.valueOf(electricBike.getBikeCode()));
        status.setText((electricBike.getStatus() > 0)?"đã cho thuê": "sẵn sàng");
        image.setImage(new Image(electricBike.getImage()));
        battery.setText(String.valueOf(electricBike.getBattery()));
    }

    public void viewBike() throws IOException {
    	FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "ViewElectricBike.fxml"
                )
        );

        FXMLLoader headerLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
        AnchorPane headerPane = headerLoader.load();

        AnchorPane parentPane = loader.load();

        ViewElectricBikeController controller =
                loader.<ViewElectricBikeController>getController();
        controller.initData(this.electricBike);
        controller.setMainPane(getMainPane());
        ((HeaderController) headerLoader.getController()).setMainPane(getMainPane());

        getMainPane().getChildren().clear();
        getMainPane().getChildren().add(headerPane);
        headerPane.setLayoutY(0);
        getMainPane().getChildren().add(parentPane);
        parentPane.setLayoutY(100);
    }

}
