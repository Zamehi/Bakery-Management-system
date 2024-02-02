package com.example.sda_project23;

import BL.BakeryControllor;
import BL.Sales;
import BL.Zemployee;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class A22trackSalesControllor  {

    @FXML
    private Button backArrow;

    @FXML
    private Button exit;

    @FXML
    private Button generate1;

    @FXML
    private TextField month;



    @FXML
    private TextArea resultConsole;

    @FXML
    private CategoryAxis x1;

    @FXML
    private NumberAxis y1;


    @FXML
    private TextField year;
    @FXML
    private BarChart< String, Number> monthChart;


    //
    private Stage stage;
    private Scene scene;
    private Parent root;

    BL.BakeryControllor b = new BakeryControllor();
    @FXML
    void oncancelButtonClick(ActionEvent event)
    {

        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();

    }


    @FXML
    void switchScene(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("welcome_admin_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void initialize(ActionEvent event)
    {
       x1.setLabel("Month");  // Change "X-Axis Label" to your desired label
       y1.setLabel("Revenue Generated");  // Change "Y-Axis Label" to your desired label

       // BarChart<String, Number> barChart = new BarChart<>(x1, y1);

        String inputText = month.getText().trim(); // Trim to remove leading/trailing whitespaces
        if (!inputText.isEmpty())
        {
            try
            {
                int month1 = Integer.parseInt(inputText);

                b.sales.trackViaYear(month1, monthChart);
                resultConsole.setText("Generated Successfully!");
            }
            catch (NumberFormatException e)
            {
                // Handle the case where input is not a valid integer
                System.out.println("Invalid year format");
            }
            catch (SQLException e)
            {

                throw new RuntimeException(e);
            }
        }
        else
        {
            // Handle the case where the input is empty
            System.out.println("Please enter an Employee ID");
        }


    }
}
