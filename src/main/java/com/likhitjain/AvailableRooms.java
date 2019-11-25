package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: Available Rooms SQL Query...

public class AvailableRooms {

    @FXML
    private TableView<Room> availableRoomsTable = new TableView<>();
    @FXML
    private TableColumn<Room, String> availableRoomsColumn = new TableColumn<>("Available Rooms");

    private Connection connection = ConnectionManager.getConnection();
    private Statement statement = connection.createStatement();

    public AvailableRooms() throws SQLException {}

    public void onBack() throws IOException {
        App.setRoot("wardenHome");
    }

    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }
}