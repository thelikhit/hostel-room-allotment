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

public class RoommateDetailsForStudent implements Initializable {

    private static String roommatefName1, roommatefName2;
    private static String roommatelName1, roommatelName2;
    private static String roommateDept1, roommateDept2;
    private static String roommateSem1, roommateSem2;
    private static String roommateContact1, roommateContact2;

    @FXML
    public TableView<Student> roommateDetailsTable = new TableView<>();

    @FXML
    private TableColumn<Student, String> fNameColumn = new TableColumn<>();
    @FXML
    private TableColumn<Student, String> lNameColumn = new TableColumn<>();
    @FXML
    private TableColumn<Student, String> contactColumn = new TableColumn<>();
    @FXML
    private TableColumn<Student, String> deptColumn = new TableColumn<>();
    @FXML
    private TableColumn<Student, String> semColumn = new TableColumn<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        deptColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        semColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));

        ObservableList<Student> list = getRoommateDetailsList();
        roommateDetailsTable.setItems(list);
    }

    private ObservableList<Student> getRoommateDetailsList() {
        Student roommate1 = new Student(roommatefName1, roommatelName1, roommateContact1, roommateDept1, roommateSem1);
        Student roommate2 = new Student(roommatefName2, roommatelName2, roommateContact2, roommateDept2, roommateSem2);

        return FXCollections.observableArrayList(roommate1, roommate2);
    }

    static void setRoommateDetails(String fname, String lName, String dept, String sem, String contact) {
        roommatefName1 = fname;
        roommatelName1 = lName;
        roommateDept1 = dept;
        roommateSem1 = sem;
        roommateContact1 = contact;
    }

    static void setRoommateDetails(String fname1, String lName1, String dept1, String sem1, String contact1,
                                   String fname2, String lName2, String dept2, String sem2, String contact2 ) {
        roommatefName1 = fname1;
        roommatelName1 = lName1;
        roommateDept1 = dept1;
        roommateSem1 = sem1;
        roommateContact1 = contact1;

        roommatefName2 = fname2;
        roommatelName2 = lName2;
        roommateDept2 = dept2;
        roommateSem2 = sem2;
        roommateContact2 = contact2;
    }

    public void onBack() throws IOException {
        App.setRoot("studentHome");
    }

    public void onClose() throws IOException {
        App.setRoot("studentHome");
    }

    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }
}
