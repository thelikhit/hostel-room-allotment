package com.likhitjain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

// TODO: Available Rooms SQL Query...

public class AvailableRooms implements Initializable {

    @FXML
    private TableView<Room> availableRoomsTable = new TableView<>();
    @FXML
    private TableColumn<Room, String> availableRoomsColumn = new TableColumn<>("Available Rooms");

    private Connection connection = ConnectionManager.getConnection();
    private Statement statement = connection.createStatement();

    private static String availableRooms = "";

    public AvailableRooms() throws SQLException {}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String QUERY = "SELECT R.r_id FROM Hostel.Room as R WHERE R.r_id NOT IN (SELECT S.room FROM Hostel.Student as S);";

        try {
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                availableRooms += resultSet.getString(1) + " ";
            }
        }
        catch (Exception e) {
            AlertBox.infoBox("An error occurred.", "Alert");
        }
        availableRoomsColumn.setCellValueFactory(new PropertyValueFactory<>("roomID"));

        ObservableList<Room> list = getAvailableRooms();
        availableRoomsTable.setItems(list);
    }

    private ObservableList<Room> getAvailableRooms() {
        Room room = new Room(availableRooms);
        return FXCollections.observableArrayList(room);
    }


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