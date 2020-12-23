package org.openjfx;

// import application.pages.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private AnchorPane mainPane;

    public MainController() {
        mainPane = new AnchorPane();
    }

    public void initialize() throws Exception {


        FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        AnchorPane homePane = homeLoader.load();
        System.out.println("in init main " );
        ((HomeController) homeLoader.getController()).setMainPane(mainPane);
        // load header*
        FXMLLoader headerLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
        AnchorPane headerPane = headerLoader.load();
        ((HeaderController) headerLoader.getController()).setMainPane(mainPane);
        mainPane.getChildren().add(headerPane);
        headerPane.setLayoutY(0);
        mainPane.getChildren().add(homePane);
        homePane.setLayoutY(100);
    }
}
