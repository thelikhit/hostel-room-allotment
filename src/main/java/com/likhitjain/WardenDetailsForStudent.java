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
import java.util.ResourceBundle;

public class WardenDetailsForStudent implements Initializable {

    private static String empID;
    private static String wardenName;
    private static String wardenContact;

    @FXML
    public TableView<Warden> wardenDetailsTable = new TableView<>();

    @FXML
    public TableColumn<Warden, String> wardenNameColumn = new TableColumn<>("Warden Name");
    @FXML
    public TableColumn<Warden, String> empIDColumn = new TableColumn<>("Emp ID");
    @FXML
    public TableColumn<Warden, String> wardenContactColumn  = new TableColumn<>("Contact");

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

        ObservableList<Warden> list;
        list = getWardenList();
        wardenDetailsTable.setItems(list);
    }

    private ObservableList<Warden> getWardenList() {
        Warden warden = new Warden(wardenName, empID, wardenContact);
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
