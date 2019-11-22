package com.likhitjain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// TODO: Allocation algorithm

public class ApplyForRoom implements Initializable {

    @FXML
    public ComboBox firstRoomPrefText;
    @FXML
    public ComboBox secondRoomPrefText;
    @FXML
    public ComboBox thirdRoomPrefText;

    @FXML
    private TableView<RoomType> roomTypeTable = new TableView<>();
    @FXML
    private TableColumn<RoomType, String> roomTypeIDColumn = new TableColumn<>("Room Type ID");
    @FXML
    private TableColumn<RoomType, String> occupancyColumn = new TableColumn<>("Occupancy");
    @FXML
    private TableColumn<RoomType, String> attachedBathroomColumn = new TableColumn<>("Bathroom Attached");
    @FXML
    private TableColumn<RoomType, Integer> roomFeesColumn = new TableColumn<>("Fees per year");
    @FXML
    private TableColumn<RoomType, String> roomDescriptionColumn = new TableColumn<>("Room Description");


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        roomTypeIDColumn.setCellValueFactory(new PropertyValueFactory<>("rTypeID"));
        occupancyColumn.setCellValueFactory(new PropertyValueFactory<>("occupancy"));
        attachedBathroomColumn.setCellValueFactory(new PropertyValueFactory<>("attachedBathroom"));
        roomFeesColumn.setCellValueFactory(new PropertyValueFactory<>("fees"));
        roomDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("roomDesc"));

        ObservableList<RoomType> list = getUserList();
        roomTypeTable.setItems(list);
    }

    private ObservableList<RoomType> getUserList() {
        RoomType roomType1 = new RoomType("RT10", "Single", "No", 170000, "NA");
        RoomType roomType2 = new RoomType("RT11", "Single", "Yes", 200000, "NA");
        RoomType roomType3 = new RoomType("RT21", "Double", "No", 100000, "NA");
        RoomType roomType4 = new RoomType("RT21", "Double", "Yes", 150000, "NA");
        RoomType roomType5 = new RoomType("RT30", "Triple", "No", 50000, "NA");
        RoomType roomType6 = new RoomType("RT31", "Triple", "Yes", 80000, "NA");

        return FXCollections.observableArrayList(roomType1, roomType2, roomType3, roomType4, roomType5, roomType6);
    }

    public void onApplyButtonClick() {
        System.out.println(firstRoomPrefText.getValue());
        System.out.println(secondRoomPrefText.getValue());
        System.out.println(thirdRoomPrefText.getValue());

        //TODO: Room Allotment algorithm...!!!
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
