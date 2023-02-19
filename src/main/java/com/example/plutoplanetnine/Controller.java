package com.example.plutoplanetnine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    //the method is placed in Scene Builder under "Code" then "OnAction" add the Method name to the Specific button
    public void loginButton(ActionEvent event) {
        if (usernameTextField.getText().isBlank()==false && (passwordPasswordField.getText().isBlank()==false)){
            //loginMessageLabel.setText("You have successful logged in!");
            validateLogin();
        }else{
            loginMessageLabel.setText("Please enter username and password!");
        }
    }

    //creates an Action Event when the "Cancel" Button is pressed. Closes the GUI.
    //cancelButton is cast as a "Stage."
    @FXML
    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection(); //creates a new Connection Instance of the class (connectNow)
        Connection connectDb = connectNow.getConnection(); //creates a new Connection variable

        String verifyLogin = "SELECT count(1) FROM Users WHERE userName = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() +"'";
         try{
             Statement statement = connectDb.createStatement();
             ResultSet queryResult = statement.executeQuery(verifyLogin);

             while(queryResult.next()){
                 if(queryResult.getInt(1)==1){
                     loginMessageLabel.setText("Welcome " + usernameTextField.getText() + " !");
                 }else{
                     loginMessageLabel.setText("Invalid login, please try again!");
                 }
             }
         }catch(SQLException e){
             e.printStackTrace();

         }
    }
}
