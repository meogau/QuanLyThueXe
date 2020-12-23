package org.openjfx;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.AnchorPane;

public class HeaderController extends AbstractNode{
    @FXML
    private Button homeBtn;
    @FXML
    private Button parkBtn;
    @FXML
    private Button returnBtn;
    @FXML
    private ButtonBar buttonBar;
    // private AnchorPane mainPane;

    public HeaderController() throws Exception {
        homeBtn = new Button("Trang chủ");
        parkBtn = new Button("Danh sách bãi xe");
        // returnBtn = new Button("Return Bike");
        buttonBar = new ButtonBar();
        // this.mainPane = mainPane;
        System.out.println("Header constructor is called");
    }

    private void setOnClickForBtns() {
        homeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("HomeBtn clicked");
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
        });

        parkBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                FXMLLoader bikeParksLoader = new FXMLLoader(getClass().getResource("BikeParks2.fxml"));
                FXMLLoader headerLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
                AnchorPane bikeParksPane = new AnchorPane();
                AnchorPane headerPane = new AnchorPane();
                try {
                    bikeParksPane = bikeParksLoader.load();
                    headerPane = headerLoader.load();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                ((HeaderController)headerLoader.getController()).setMainPane(getMainPane());
                ((ParkingScreenController) bikeParksLoader.getController()).setMainPane(getMainPane());
                ((ParkingScreenController) bikeParksLoader.getController()).init();
                getMainPane().getChildren().clear();
                getMainPane().getChildren().add(headerPane);
                headerPane.setLayoutY(0);
                getMainPane().getChildren().add(bikeParksPane);
                bikeParksPane.setLayoutY(100);
                // getMainPane().getScene().getWindow().setHeight(730);
            }
        });
    }
    //public void setParentCoontroller()
//    public void setMainPane(AnchorPane mainPane) {
//        this.mainPane = mainPane;
//    }
    public void initialize() throws Exception {
        System.out.println("Header initialize is called");
        buttonBar.getButtons().setAll(homeBtn, parkBtn);
        setOnClickForBtns();
        System.out.println("Header Endned");
    }
    
    @FXML
    private void goToEnterBikeCode() throws Exception{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("QRInputScreen.fxml"));
    	AnchorPane pane = loader.load();
    	((EnterBikeCodeController) loader.getController()).setMainPane(getMainPane());
    	getMainPane().getChildren().clear();
    	getMainPane().getChildren().add(pane);
    	getMainPane().getScene().getWindow().setWidth(600);
    	getMainPane().getScene().getWindow().setHeight(400);
    }
}
