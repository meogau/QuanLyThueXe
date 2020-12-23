module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.json;
    requires httpclient;
    requires httpcore;
    requires commons.codec;
	requires javafx.graphics;

    opens org.openjfx to javafx.fxml;

    exports org.openjfx;

}