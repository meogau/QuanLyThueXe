package org.openjfx;

import dataAccess.entities.Bike;
import dataAccess.entities.Parking;
import dataAccess.entities.StandBike;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class OneStandBikeScreenController extends AbstractNode{

    private Parking park;

    @FXML
    private Label bikeCode;
    @FXML
    private Label status;
    @FXML
    private ImageView image;

    private StandBike standBike;

    public OneStandBikeScreenController() {
    	
        System.out.println("Vao one Bike controller");
        bikeCode = new Label();
        status = new Label();
        image = new ImageView();
        
    }
    public void setBikeInfo(StandBike standBike) {
        this.standBike = standBike;
        bikeCode.setText(String.valueOf(standBike.getBikeCode()));
        status.setText((standBike.getStatus() > 0)?"đã cho thuê": "sẵn sàng");
        image.setImage(new Image(standBike.getImage()));
        
    }

    public void viewBike() throws IOException {
    	FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "ViewStandBike.fxml"
                )
        );

        FXMLLoader headerLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
        AnchorPane headerPane = headerLoader.load();

        AnchorPane parentPane = loader.load();

        ViewStandBikeController controller =
                loader.<ViewStandBikeController>getController();
        controller.initData(this.standBike);
        controller.setMainPane(getMainPane());
        ((HeaderController) headerLoader.getController()).setMainPane(getMainPane());

        getMainPane().getChildren().clear();
        getMainPane().getChildren().add(headerPane);
        headerPane.setLayoutY(0);
        getMainPane().getChildren().add(parentPane);
        parentPane.setLayoutY(100);
    }

}
