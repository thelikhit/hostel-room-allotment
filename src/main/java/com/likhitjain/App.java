package com.likhitjain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
//        try {
//
//            String url = "jdbc:mysql://localhost:3306/Hostel";
//            String uName = "root";
//            String passwd = "1998";
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Connection connection = DriverManager.getConnection(url, uName, passwd);
//            Statement statement = connection.createStatement();
//
//            int insertID = 1;
//            // String insertString = "Edwin Van Der Sar";
//            String query = "INSERT INTO Hostel.Room VALUES(?);";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, insertID);
//            // preparedStatement.setString(2, insertString);
//            int rowsAffected = preparedStatement.executeUpdate();
//            System.out.println(rowsAffected + " row(s) affected.");
//
////            query = "SELECT * FROM Employee";
////            ResultSet resultSet = statement.executeQuery(query);
////            while(resultSet.next()) {
////                String data = resultSet.getInt("empID") + " : " + resultSet.getString("empName");
////                System.out.println(data);
////            }
//
//            statement.close();
//            connection.close();
//            System.out.println("DB CONNECTION OK");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        // scene = new Scene(loadFXML("mainMenu"));
        scene = new Scene(loadFXML("adminLogin"));
        stage.setScene(scene);
        stage.show();
    }

}