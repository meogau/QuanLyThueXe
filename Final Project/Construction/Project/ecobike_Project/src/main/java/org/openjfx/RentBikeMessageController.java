package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RentBikeMessageController {
    @FXML
    private Label error;
    @FXML
    private DialogPane dialog;

    public RentBikeMessageController() {
        error = new Label();
        dialog = new DialogPane();
    }

    public void show(String errorS, String dialogS) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "RentBikeMessage.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );
        RentBikeMessageController controller =
                loader.<RentBikeMessageController>getController();
        controller.initData(errorS,dialogS);

        stage.show();
    }
 public void initData(String errorS, String dialogS){
        this.error.setText(errorS);
        this.dialog.setContentText(dialogS);

 }
}
