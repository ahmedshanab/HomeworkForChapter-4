/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ViewRegistController implements Initializable {

    @FXML
    private TextField textfieldID;
    @FXML
    private TextField textfieldName;
    @FXML
    private TextField textfieldMajor;
    @FXML
    private TextField textfieldGrade;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Integer> tcGrade;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonDelete;
    @FXML
    private TableView<Student> tableView;
    Statement statement ; 
    @FXML
    private Button buttonshow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
           Class.forName("com.mysql.idbc.Driver");
           Connection con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            this.statement = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
           
        }
        tcID.setCellValueFactory(new PropertyValueFactory("ID"));
         tcName.setCellValueFactory(new PropertyValueFactory("Name"));
          tcMajor.setCellValueFactory(new PropertyValueFactory("Major"));
           tcGrade.setCellValueFactory(new PropertyValueFactory("Grade"));
    }    

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception {
       Integer id = Integer.parseInt(textfieldID.getText());
       String name = textfieldName.getText();
       String major = textfieldMajor.getText();
       Integer grade = Integer.parseInt(textfieldGrade.getText());
       String sql = "Insert Into student values ( "+id+ " , ' "+name+  " ' ,'" +major +"', "+grade+" )";
       this.statement.executeUpdate(sql);
        
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
    }

    @FXML
    private void buttonShowHandel(ActionEvent event) throws SQLException {
        ResultSet rs = this.statement.executeQuery("Select * From Student");
        tableView.getItems().clear();
        while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("ID"));
            student.setName(rs.getString("Name"));
            student.setMajor(rs.getString("Major"));
            student.setGrade(rs.getInt("Grade"));
            tableView.getItems().add(student);
            }
    }
    
    private void ResetControlls(){
        textfieldID.setText("");
        textfieldName.setText("");
        textfieldMajor.setText("");
        textfieldGrade.setText("");
        tableView.getItems().clear();
        
    }
    
}
