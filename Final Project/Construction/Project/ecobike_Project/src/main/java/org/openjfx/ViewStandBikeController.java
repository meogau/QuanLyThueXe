package org.openjfx;

import dataAccess.entities.ElectricBike;
import dataAccess.entities.StandBike;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewStandBikeController extends AbstractNode{
    @FXML
    private Label name;
    @FXML
    private Label description;
    @FXML
    private Label pilePrice;
    @FXML
    private Label status;
    @FXML
    private Label bikeCode;
    @FXML
    private ImageView image;

    private StandBike standBike;

    @FXML
    private Button rentBike;


    public ViewStandBikeController() {
        name= new Label();

        description = new Label();
        pilePrice = new Label();
        status = new Label();
        image = new ImageView();
        bikeCode = new Label();
        rentBike = new Button("Thuê xe ngay");
    }

    public void initData(StandBike bike){
        this.standBike = bike;
        name.setText(bike.getName());
        description.setText(bike.getDescription());
        pilePrice.setText(String.valueOf(bike.getPrice()*0.6));
        image.setImage(new Image(bike.getImage()));
        if(bike.getStatus()==1) status.setText("Đã cho thuê");
        else  status.setText("Sẵn sàng");
        bikeCode.setText(String.valueOf(bike.getBikeCode()));
        if(status.getText().equals("Đã cho thuê")) {
        	rentBike.setDisable(true);
        }
    }
    public void handleRentBikeAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "PaymentInfo.fxml"
                )
        );

        AnchorPane paymentPane = loader.load();
      ((PaymentScreenController) loader.getController()).setMainPane(getMainPane());
      ((PaymentScreenController) loader.getController()).setBike(this.standBike);
        getMainPane().getChildren().clear();
        getMainPane().getChildren().add(paymentPane);
        getMainPane().getScene().getWindow().setHeight(paymentPane.getHeight());
    }
}
