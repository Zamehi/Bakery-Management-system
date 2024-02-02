package com.example.sda_project23;

import BL.BakeryControllor;
import BL.Zdiscount;
import BL.Zdiscount;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Use case 9
public class A1updateDiscountsControllor
{
    @FXML
    private TableView E_table;
    @FXML
    private TableColumn<BL.Zdiscount, Integer> colDiscount;

    @FXML
    private TableColumn<BL.Zdiscount, String> colEndTime;

    @FXML
    private TableColumn<BL.Zdiscount, String> colStartTime;

    @FXML
    private TableColumn<BL.Zdiscount, Integer> colitemID;
    @FXML
    private Button backArrow;
    @FXML
    private TextField dd1;
    @FXML
    private TextField dd2;
    @FXML
    private TextField discount;
    @FXML
    private Button exit;
    @FXML
    private Button flatDiscount;
    @FXML
    private TextField hh1;
    @FXML
    private TextField hh2;
    @FXML
    private TextField id;
    @FXML
    private TextField mi1;
    @FXML
    private TextField mi2;
    @FXML
    private TextField mm1;
    @FXML
    private TextField mm2;
    @FXML
    private Button resetDiscount;
    @FXML
    private Button view;
    @FXML
    private TextArea resultConsole;
    @FXML
    private Button setDiscount;
    @FXML
    private TextField ss1;
    @FXML
    private TextField ss2;
    @FXML
    private TextField yy1;
    @FXML
    private TextField yy2;
    @FXML
    private BarChart< String, Number> monthChart;
    //
    private Stage stage;
    private Scene scene;
    private Parent root;


    BL.BakeryControllor b = new BakeryControllor();


    // ------------- CONCATENATE ----------------
    public String concatenate(String yy,String mm,String dd, String hh, String mi, String ss)
    {
        // '0000-00-00 00:00:00'
        String result = yy.concat("-").concat(mm).concat("-").concat(dd).concat(" ").concat(hh).concat(".").concat(mi).concat(":").concat(ss);
        return result;
    }
    // -------------- TIME STAMP -----------------


    // -------------- 1. FLAT DISCOUNT ---------------
    @FXML
    void onFlatDiscount(ActionEvent event) throws ParseException {
        String startTime = concatenate (yy1.getText(), mm1.getText(),dd1.getText(), hh1.getText(), mi1.getText(), ss1.getText());
        String endTime = concatenate (yy2.getText(), mm2.getText(),dd2.getText(), hh2.getText(), mi2.getText(), ss2.getText());

        String inputText2 = discount.getText().trim(); // Trim to remove leading/trailing whitespaces
        if (!inputText2.isEmpty() && startTime != "-- .:"&& endTime !="-- .:" )
        {
            try {
                int dis = Integer.parseInt(inputText2);
                // Now 'employeeId' is the integer value of the text
                b.discount.setFlatDiscount(dis, startTime, endTime);
                ObservableList<Zdiscount> empList= b.discount.getAllRecords();
                populateTable(empList);
                if (empList.size() > 0)
                {
                    populateTable(empList);
                    resultConsole.setText("Employee Searched successfully!");
                } else {
                    resultConsole.setText("Employee does not exist");
                }
                // You can use 'employeeId' in your logic here
            } catch (NumberFormatException e)
            {
                // Handle the case where input is not a valid integer
                System.out.println("Invalid Employee ID format");
            } catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }
        else
        {
            // Handle the case where the input is empty
            resultConsole.setText("Please set start and end date");
            System.out.println("Please enter an Employee ID");
        }
    }
    // -------------- 2. RESET DISCOUNT ---------------
    @FXML
    void onResetDiscount(ActionEvent event)
    {
        try
        {
            b.discount.resetDiscount();
            ObservableList<Zdiscount> empList= b.discount.getAllRecords();
            populateTable(empList);
            if (empList.size() > 0)
            {
                populateTable(empList);
                resultConsole.setText("Employee Searched successfully!");
            } else
            {
                resultConsole.setText("Employee does not exist");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid date format");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    // -------------- 3. SET DISCOUNT ---------------
    @FXML
    void onSetDiscount(ActionEvent event) throws ParseException {
        String startTime = concatenate (yy1.getText(), mm1.getText(),dd1.getText(), hh1.getText(), mi1.getText(), ss1.getText());
        String endTime = concatenate (yy2.getText(), mm2.getText(),dd2.getText(), hh2.getText(), mi2.getText(), ss2.getText());

        //
        String inputText1 = discount.getText().trim(); // Trim to remove leading/trailing whitespaces
        String inputText2 = id.getText().trim(); // Trim to remove leading/trailing whitespaces
        if (!inputText2.isEmpty() && !inputText1.isEmpty())
        {
            try
            {
                int dis = Integer.parseInt(inputText1);
                int itemId = Integer.parseInt(inputText2);
                // Now 'employeeId' is the integer value of the text
                b.discount.onSetDiscount(dis, itemId, startTime, endTime);
                ObservableList<Zdiscount> empList= b.discount.getAllRecords();
                populateTable(empList);
                if (empList.size() > 0)
                {
                    populateTable(empList);
                    resultConsole.setText("Employee Searched successfully!");
                } else {
                    resultConsole.setText("Employee does not exist");
                }
                // You can use 'employeeId' in your logic here
            }
            catch (NumberFormatException e)
            {
                // Handle the case where input is not a valid integer
                System.out.println("Invalid Employee ID format");
            } catch (SQLException e)
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


    // ----------- 4. DISPLAY EMPLOYEE ----------
    @FXML
    public void populateTable( ObservableList<Zdiscount> empList)
    {
        E_table.setItems(empList);
    }
    @FXML
    public void initialize(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        // Setting values in columns of table
        colitemID.setCellValueFactory(cellData->cellData.getValue().productIdProperty().asObject());
        colDiscount.setCellValueFactory(cellData->cellData.getValue().amountProperty().asObject());
        //name1.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        colStartTime.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());
        colEndTime.setCellValueFactory(cellData->cellData.getValue().endTimeProperty());

        // Making list to populate the entire table with above columns
        ObservableList<Zdiscount> empList= b.discount.getAllRecords();
        populateTable(empList);
    }



    // ------------- 7. EXIT PROGRAM ----------------
    @FXML
    void oncancelButtonClick(ActionEvent event)
    {

        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();

    }


    // ------------- 6. SWITCH SCENES -------------
    @FXML
    void switchScene(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("welcome_admin_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}


