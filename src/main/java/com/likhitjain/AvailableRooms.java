package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AvailableRooms {

    @FXML
    private TableView<AvailableRoomsTable> availableRoomsTable = new TableView<>();
    @FXML
    private TableColumn<AvailableRoomsTable, String> availableRoomsColumn = new TableColumn<>("Available Rooms");

    private Connection connection = ConnectionManager.getConnection();
    private Statement statement = connection.createStatement();

    public AvailableRooms() throws SQLException {}
}