package com.example.sda_project23;

import BL.BakeryControllor;
import BL.Zkitchen;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class A4hygieneStatusControllor
{
    @FXML
    private TableView E_table;

    @FXML
    private Button add1;

    @FXML
    private Button backArrow;

    @FXML
    private TableColumn<Zkitchen, Integer> colID;

    @FXML
    private TableColumn<Zkitchen, Integer> colRequest;

    @FXML
    private TableColumn<Zkitchen, String> colStatus;

    @FXML
    private Button delete;

    @FXML
    private Button exit;

    @FXML
    private TextField id;

    @FXML
    private Label prompt;

    @FXML
    private TextArea resultConsole;

    @FXML
    private Button search;

    @FXML
    private Button view;


    private Stage stage;
    private Scene scene;
    private Parent root;

    // -----------------------------------------
    BakeryControllor b = new BakeryControllor();
    
    
    // ----------- 2. UPDATE EMPLOYEE ----------
    @FXML
    public void updateEmployee(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        String inputText = id.getText().trim(); // Trim to remove leading/trailing whitespaces
        int x = 0;
        if (!inputText.isEmpty()) {
            try {
                int employeeId = Integer.parseInt(inputText);
                // Now 'employeeId' is the integer value of the text
                x = b.kitchen.updateEmployee(employeeId);
                if (x >= 5)
                {
                    resultConsole.setText("Click FIRE to delete the employee" );
                }
                ObservableList<Zkitchen> empList= b.kitchen.getAllRecords();
                populateTable(empList);

                if (empList.size() > 0)
                {
                    populateTable(empList);
                    resultConsole.setText("Employee Searched successfully!");
                } else {
                    resultConsole.setText("Employee does not exist");
                }

                // You can use 'employeeId' in your logic here
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                System.out.println("Invalid Employee ID format");
            }
        } else
        {
            // Handle the case where the input is empty
            System.out.println("Please enter an Employee ID");
        }
    }

    // ----------- 3. DELETE EMPLOYEE ----------
    @FXML
    public void deleteEmployee(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        String inputText = id.getText().trim(); // Trim to remove leading/trailing whitespaces
        // String inputText2 = salary.getText().trim(); // Trim to remove leading/trailing whitespaces

        if (!inputText.isEmpty()) {
            try {
                int employeeId = Integer.parseInt(inputText);
                //int salary1 = Integer.parseInt(inputText2);
                // Now 'employeeId' is the integer value of the text
                b.kitchen.deleteEmployee(employeeId);
                ObservableList<Zkitchen> empList= b.kitchen.getAllRecords();
                populateTable(empList);

                if (empList.size() > 0)
                {
                    populateTable(empList);
                    resultConsole.setText("Employee Searched successfully!");
                } else {
                    resultConsole.setText("Employee does not exist");
                }

                // You can use 'employeeId' in your logic here
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                System.out.println("Invalid Employee ID format");
            }
        } else
        {
            // Handle the case where the input is empty
            System.out.println("Please enter an Employee ID");
        }
    }
    // ----------- 4. DISPLAY EMPLOYEE ----------

    @FXML
    public void populateTable( ObservableList<Zkitchen> empList)
    {
        E_table.setItems(empList);
    }
    @FXML
    public void initialize(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        // Setting values in columns of table
        colID.setCellValueFactory(cellData->cellData.getValue().idProperty().asObject());
        colStatus.setCellValueFactory(cellData->cellData.getValue().statusProperty());
        colRequest.setCellValueFactory(cellData->cellData.getValue().requestProperty().asObject());

        // Making list to populate the entire table with above columns
        ObservableList<Zkitchen> empList= b.kitchen.getAllRecords();
        populateTable(empList);
    }

    // ------------ 5. SEARCH EMPLOYEE ------------
    @FXML
    public void searchEmployee(ActionEvent event)throws SQLException
    {
        String inputText = id.getText().trim(); // Trim to remove leading/trailing whitespaces

        if (!inputText.isEmpty()) {
            try {
                int employeeId = Integer.parseInt(inputText);
                // Now 'employeeId' is the integer value of the text
                ObservableList<Zkitchen> empList = b.kitchen.searchEmployee(employeeId);

                if (empList.size() > 0)
                {
                    populateTable(empList);
                    resultConsole.setText("Employee Searched successfully!");
                } else {
                    resultConsole.setText("Employee does not exist");
                }

                // You can use 'employeeId' in your logic here
            } catch (NumberFormatException e) {
                // Handle the case where input is not a valid integer
                System.out.println("Invalid Employee ID format");
            }
        } else
        {
            // Handle the case where the input is empty
            System.out.println("Please enter an Employee ID");
        }
    }

    // ------------- 6. SWITCH SCENES -------------
    @FXML
    public void switchScene(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("welcome_admin_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    // ------------- 7. EXIT PROGRAM ----------------
    @FXML
    protected void oncancelButtonClick(ActionEvent e)
    {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

}
