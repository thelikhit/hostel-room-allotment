package com.likhitjain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class WardenDetailsForStudent implements Initializable {

    static String empID;
    static String wardenName;
    static String wardenContact;

    @FXML
    public TableView<WardenTable> wardenDetailsTable = new TableView<>();

    @FXML
    public TableColumn<WardenTable, String> wardenNameColumn = new TableColumn<>("Warden Name");
    @FXML
    public TableColumn<WardenTable, String> empIDColumn = new TableColumn<>("Emp ID");
    @FXML
    public TableColumn<WardenTable, String> wardenContactColumn  = new TableColumn<>("Contact");

    static void setWardenDetails(String id, String name, String contact) {
        empID = id;
        wardenName = name;
        wardenContact =contact;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        wardenNameColumn.setCellValueFactory(new PropertyValueFactory<>("wardenName"));
        empIDColumn.setCellValueFactory(new PropertyValueFactory<>("empID"));
        wardenContactColumn.setCellValueFactory(new PropertyValueFactory<>("wardenContact"));

        ObservableList<WardenTable> list = null;
        try {
            list = getWardenList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        wardenDetailsTable.setItems(list);
    }

    private ObservableList<WardenTable> getWardenList() throws SQLException {

        WardenTable warden = new WardenTable(wardenName, empID, wardenContact);

        return FXCollections.observableArrayList(warden);
    }

    public void onBack() throws IOException {
        App.setRoot("studentHome");
    }
    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }
}
