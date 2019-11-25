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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ApplyForRoom implements Initializable {

    @FXML
    public ComboBox firstRoomPrefText;
    @FXML
    public ComboBox secondRoomPrefText;
    @FXML
    public ComboBox thirdRoomPrefText;

    private static String gender, studentUSN;

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

    private Connection connection = ConnectionManager.getConnection();
    private Statement statement = connection.createStatement();

    public ApplyForRoom() throws SQLException {}

    static void setGender(String g) {
        if (g.equals("M"))
            gender = "Boys";
        else
            gender = "Girls";
    }

    static void setStudentUSN(String usn) {
        studentUSN = usn;
    }

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
        List<String> roomTypePrefs = new ArrayList<>();
        roomTypePrefs.add(firstRoomPrefText.getValue().toString());
        roomTypePrefs.add(secondRoomPrefText.getValue().toString());
        roomTypePrefs.add(thirdRoomPrefText.getValue().toString());
        System.out.println("Preferences: ");
        System.out.println(Arrays.toString(roomTypePrefs.toArray()));

        try {
            for (String roomTypePref : roomTypePrefs) {
                String QUERY = "SELECT r_id FROM Hostel.Room as R JOIN Hostel.RoomType AS RT JOIN Hostel.Block AS B WHERE R.r_type_id = RT.r_type_id AND R.b_id = B.b_id AND b_type='" + gender + "' AND RT.r_type_id='" + roomTypePref + "';";

                ResultSet resultSet = statement.executeQuery(QUERY);

                List<String> roomOptions = new ArrayList<>();

                while (resultSet.next()) {
                    roomOptions.add(resultSet.getString(1));
                }
                System.out.println(Arrays.toString(roomOptions.toArray()));

                for (String roomOption : roomOptions) {

                    System.out.println("Room Option: " + roomOption + " and RoomType Option: " + roomTypePref);

                    String QUERY_MAX_OCCUPANCY = "SELECT occupancy FROM Hostel.RoomType AS RT JOIN Hostel.Room AS R WHERE RT.r_type_id = R.r_type_id AND R.r_id = '" + roomOption + "';";
                    ResultSet resultSetOccupancy = statement.executeQuery(QUERY_MAX_OCCUPANCY);
                    resultSetOccupancy.next();
                    int maxOccupancy = resultSetOccupancy.getInt(1);
                    System.out.println("Max. occupancy: " + maxOccupancy);

                    String QUERY_CURR_OCCUPANCY = "SELECT COUNT(*) FROM Hostel.Room AS R JOIN Hostel.Student AS S WHERE " +
                            "R.r_id = S.room AND room='" + roomOption + "';";
                    ResultSet resultSetCurrOccupancy = statement.executeQuery(QUERY_CURR_OCCUPANCY);
                    resultSetCurrOccupancy.next();
                    int currOccupancy = resultSetCurrOccupancy.getInt(1);
                    System.out.println("Current occupancy: " + currOccupancy);

                    if (currOccupancy < maxOccupancy) {
                        String QUERY_ALLOT = "UPDATE Hostel.Student SET room = '" + roomOption + "' WHERE usn='" + studentUSN + "';";
                        statement.executeUpdate(QUERY_ALLOT);
                        AlertBox.infoBox("Room " + roomOption + " allotted of type " + roomTypePref, "Success");
                        App.setRoot("studentHome");
                        return;
                    }
                    else
                        System.out.println("Max occupancy reached\n");
                }
            }
            AlertBox.infoBox("Preferred room not available", "");
        }
        catch (Exception e) {
            AlertBox.infoBox("Room could not be allotted.", "Allotment error");
            e.printStackTrace();
        }
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
