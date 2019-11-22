package com.likhitjain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RoomDetailsSearchForWarden implements Initializable {

    private String roomID;
    private String blockName;
    private String roomDesc;
    private String usns;

    @FXML
    public TextField roomIDText;
    @FXML
    private TableView<RoomTable> roomDetailsTable = new TableView<>();
    @FXML
    public TableColumn<RoomTable, String> roomIDColumn = new TableColumn<>("Room ID");
    @FXML
    public TableColumn<RoomTable, String> blockNameColumn = new TableColumn<>("Block Name");
    @FXML
    public TableColumn<RoomTable, String> roomDescColumn = new TableColumn<>("Room Description");
    @FXML
    public TableColumn<RoomTable, String> usnsColums = new TableColumn<>("USNs");
    @FXML
    public Button searchButton;


    public RoomDetailsSearchForWarden() throws SQLException {
    }

    private Connection connection = ConnectionManager.getConnection();
    private Statement statement = connection.createStatement();

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    private ObservableList<RoomTable> getRoomDetailsList() {
        RoomTable room = new RoomTable(roomID, blockName, roomDesc, usns);
        return FXCollections.observableArrayList(room);
    }

    public void onSearchButtonClick() {
        try {
            String QUERY = "SELECT * FROM Hostel.Room WHERE r_id='" + roomIDText.getText() + "';";
            System.out.println(QUERY);

            ResultSet resultSet = statement.executeQuery(QUERY);
            resultSet.next();

            roomID = resultSet.getString("r_id");
            String blockID = resultSet.getString("b_id");
            String rtId = resultSet.getString("r_type_id");

            QUERY = "SELECT b_name FROM HOSTEL.Block WHERE b_id='" + blockID + "';";
            resultSet = statement.executeQuery(QUERY);
            resultSet.next();
            blockName = resultSet.getString("b_name");


            QUERY = "SELECT room_desc FROM HOSTEL.RoomType WHERE r_type_id='" + rtId + "';";
            resultSet = statement.executeQuery(QUERY);
            resultSet.next();
            roomDesc = resultSet.getString("room_desc");

            QUERY = "SELECT usn from hostel.student where room='" + roomIDText.getText() + "';";
            resultSet = statement.executeQuery(QUERY);

            usns = "";

            while (resultSet.next()) {
                usns += resultSet.getString("usn") + " ";
            }

            roomIDColumn.setCellValueFactory(new PropertyValueFactory<>("roomID"));
            blockNameColumn.setCellValueFactory(new PropertyValueFactory<>("blockName"));
            roomDescColumn.setCellValueFactory(new PropertyValueFactory<>("roomDesc"));
            usnsColums.setCellValueFactory(new PropertyValueFactory<>("usns"));

            ObservableList<RoomTable> list = getRoomDetailsList();
            roomDetailsTable.setItems(list);

        }
        catch (SQLException e) {
            AlertBox.infoBox("Please enter a valid Room ID", "Alert");
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
