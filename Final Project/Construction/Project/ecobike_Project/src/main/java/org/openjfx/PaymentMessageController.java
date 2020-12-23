package org.openjfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PaymentMessageController {

    public void show() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "PaymentMessage.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );
        stage.show();
    }
}
