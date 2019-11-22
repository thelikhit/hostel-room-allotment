package com.likhitjain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class StudentDetailsSearchForWarden implements Initializable {

    @FXML
    private TextField studentUSNText;

    private String studentUSN;
    private String fName;
    private String lName;
    private String room;
    private String dept;
    private String semester;
    private String guardianName;
    private String guardianContact;
    private String contact;
    private String permAddress;

    private Connection connection = ConnectionManager.getConnection();
    private Statement statement = connection.createStatement();

    @FXML
    private TableView<StudentTable> studentDetailsTable = new TableView<>();
    @FXML
    private TableColumn<StudentTable, String> usnColumn = new TableColumn<>("USN");
    @FXML
    private TableColumn<StudentTable, String> fNameColumn = new TableColumn<>("First Name");;
    @FXML
    private TableColumn<StudentTable, String> lNameColumn= new TableColumn<>("Last Name");;
    @FXML
    private TableColumn<StudentTable, String> roomColumn = new TableColumn<>("Room");;
    @FXML
    private TableColumn<StudentTable, String> contactColumn = new TableColumn<>("Contact");;
    @FXML
    private TableColumn<StudentTable, String> deptColumn = new TableColumn<>("Department");;
    @FXML
    private TableColumn<StudentTable, String> semColumn = new TableColumn<>("Semester");;
    @FXML
    private TableColumn<StudentTable, String> gNameColumn = new TableColumn<>("Guardian Name");;
    @FXML
    private TableColumn<StudentTable, String> gContactColumn = new TableColumn<>("Guardian Contact");;
    @FXML
    private TableColumn<StudentTable, String> permAddColumn = new TableColumn<>("Permanent Address");

    public StudentDetailsSearchForWarden() throws SQLException {}


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private ObservableList<StudentTable> getStudentList() {
         StudentTable student = new StudentTable(studentUSN, fName, lName, dept, semester, guardianName, guardianContact, permAddress, contact, room);
        return FXCollections.observableArrayList(student);
    }

    public void onSearchButtonClick() {


        try {

            String QUERY = "SELECT * FROM Hostel.Student WHERE usn='" + studentUSNText.getText() + "';";
            System.out.println(QUERY);

            ResultSet resultSet = statement.executeQuery(QUERY);
            resultSet.next();

            studentUSN = resultSet.getString("usn");
            fName = resultSet.getString("f_name");
            lName = resultSet.getString("l_name");
            room = resultSet.getString("room");
            dept = resultSet.getString("department");
            semester = resultSet.getString("semester");
            guardianName = resultSet.getString("guardian_name");
            guardianContact = resultSet.getString("guardian_contact");
            permAddress = resultSet.getString("perm_address");
            contact = resultSet.getString("mobile_no");

            usnColumn.setCellValueFactory(new PropertyValueFactory<>("usn"));
            fNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
            lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
            roomColumn.setCellValueFactory(new PropertyValueFactory<>("room"));
            contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
            deptColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
            semColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
            gNameColumn.setCellValueFactory(new PropertyValueFactory<>("guardianName"));
            gContactColumn.setCellValueFactory(new PropertyValueFactory<>("guardianContact"));
            permAddColumn.setCellValueFactory(new PropertyValueFactory<>("permAddress"));

            ObservableList<StudentTable> list = getStudentList();
            studentDetailsTable.setItems(list);
        }
        catch (SQLException e) {
            AlertBox.infoBox("Please enter a valid USN", "Alert");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
