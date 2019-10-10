module com.likhitjain {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires mysql.connector.java;

    opens com.likhitjain to javafx.fxml;
    exports com.likhitjain;
}