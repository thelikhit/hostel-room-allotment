module com.likhitjain {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.likhitjain to javafx.fxml;
    exports com.likhitjain;
}