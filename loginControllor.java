package com.example.sda_project23;

import BL.Admin;
import BL.BakeryControllor;
import DB_handler.database_connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class loginControllor
{
    @FXML
    private Label afterLoginText;
    @FXML
    private TextField userText;
    @FXML
    private TextField passwordText;
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void onloginButtonClick(ActionEvent e) throws IOException
    {
        if (userText.getText().isBlank()== false && passwordText.getText().isBlank()== false)
        {
            validateLogin(e);
        }

    }

    // --------------- EXIT PROGRAM --------------
    @FXML
    protected void oncancelButtonClick(ActionEvent e)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    // ---------------   VALIDATE   --------------
    public void validateLogin(ActionEvent e) throws IOException {
        BL.BakeryControllor b = new BakeryControllor();
        int x = 0;

        x = b.admin.login(userText.getText(), passwordText.getText());
        if (x == 1)
        {
            afterLoginText.setText("Logged in successfully");
            switchScene(e);
        }
        else if (x== 0)

        {
            afterLoginText.setText("Invalid Login");
        }
        else if (x == -1)
        {
            afterLoginText.setText("unknown error");
        }

        // returning connection from function of object of the class
    }

    // ------------- 6. SWITCH SCENES -------------
    public void switchScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome_admin_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
