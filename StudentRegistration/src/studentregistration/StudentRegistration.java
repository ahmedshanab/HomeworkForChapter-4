/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class StudentRegistration extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane Hboox = FXMLLoader.load(getClass().getResource("viewRegist.fxml"));
        //Pane paneListView = FXMLLoader.load(getClass().getResource("ListViewPane.fxml"));
        Map<String , Pane> mapPanes = new TreeMap<>();
        mapPanes.put("Hboox", Hboox);  
        Scene scene = new Scene(mapPanes.get("Hboox"));
        primaryStage.setTitle("Streems App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
