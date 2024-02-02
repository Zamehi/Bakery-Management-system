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

public class adminControllor
{

    @FXML
    private Button A1;

    @FXML
    private Button A21;

    @FXML
    private Button A22;

    @FXML
    private Button A31;

    @FXML
    private Button A32;

    @FXML
    private Button A4;

    @FXML
    private Button manageDetails;
    @FXML
    private Button loginButton;
    @FXML
    private Button exit;
    @FXML
    private Button backArrow;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void onmanageDetails(ActionEvent e) throws IOException
    {
       switchScene(e);
    }

    // ------------- 6. SWITCH SCENES -------------
    @FXML
    public void switchScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("A52employeeDetails.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void switchtoLogin(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    protected void oncancelButtonClick(ActionEvent e)
    {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onA1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("A1updateDiscountsControllor.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onA21(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("A21salesControllor.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onA22(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("A22trackSales.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onA31(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("A31bakeryItems.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onA32(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("A32ingredients.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onA4(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("A4hygieneStatus.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
