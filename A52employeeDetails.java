package com.example.sda_project23;

import BL.BakeryControllor;
import BL.Employee;
import BL.Zemployee;
import DB_handler.database_connection;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
public class A52employeeDetails
{
    @FXML
    public TextField id;
    @FXML
    public TextField name;
    @FXML
    public TextField workHours;
    @FXML
    public TextField salary;
    @FXML
    public TextArea resultConsole;

    // BUTTONS
    @FXML
    public Button add;
    @FXML
    public Button update;
    @FXML
    public Button delete;
    @FXML
    public Button search;
    @FXML
    public Button view;
    @FXML
    public Button backArrow;
    @FXML
    public Button exit;


    // TABLE
    @FXML
    public TableColumn<BL.Zemployee, Integer> id1;
    @FXML
    public TableColumn<BL.Zemployee, String> name1;
    @FXML
    public TableColumn <BL.Zemployee, Integer> workHours1;
    @FXML
    public TableColumn <BL.Zemployee, Integer> salary1;
    @FXML
    public TableView  E_table;

    //
    private Stage stage;
    private Scene scene;
    private Parent root;


    // -----------------------------------------
    BakeryControllor b = new BakeryControllor();

    // goes the data that is to be shown on the screen

    //ObservableList<Employee> e= FXCollections.observableArrayList();

    // ----------- 1. INSERT EMPLOYEE ----------
    @FXML
    public void insertEmployee(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        String inputText = id.getText().trim(); // Trim to remove leading/trailing whitespaces
        String salary2 = salary.getText().trim(); // Trim to remove leading/trailing whitespaces
        String name2 = name.getText().trim(); // Trim to remove leading/trailing whitespaces
        String workHours2 = workHours.getText().trim(); // Trim to remove leading/trailing whitespaces

        if (!inputText.isEmpty()) {
            try {
                int employeeId = Integer.parseInt(inputText);
                int salary1 = Integer.parseInt(salary2);
                int wh=  Integer.parseInt(workHours2);

                // Now 'employeeId' is the integer value of the text
                b.employee.addEmployee(employeeId, name2, wh, salary1);
                ObservableList<Zemployee> empList= b.employee.getAllRecords();
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


    // ----------- 2. UPDATE EMPLOYEE ----------
    @FXML
    public void updateEmployee(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        String inputText = id.getText().trim(); // Trim to remove leading/trailing whitespaces
        String inputText2 = salary.getText().trim(); // Trim to remove leading/trailing whitespaces

        if (!inputText.isEmpty()) {
            try {
                int employeeId = Integer.parseInt(inputText);
                int salary1 = Integer.parseInt(inputText2);
                // Now 'employeeId' is the integer value of the text
                 b.employee.updateEmployee(employeeId, salary1);
                ObservableList<Zemployee> empList= b.employee.getAllRecords();
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
                b.employee.deleteEmployee(employeeId);
                ObservableList<Zemployee> empList= b.employee.getAllRecords();
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
    public void populateTable( ObservableList<Zemployee> empList)
    {
        E_table.setItems(empList);
    }
    @FXML
    public void initialize(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        // Setting values in columns of table
        id1.setCellValueFactory(cellData->cellData.getValue().idProperty().asObject());
        name1.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        salary1.setCellValueFactory(cellData->cellData.getValue().salaryProperty().asObject());
        workHours1.setCellValueFactory(cellData->cellData.getValue().workHoursProperty().asObject());

        // Making list to populate the entire table with above columns
        ObservableList<Zemployee> empList= b.employee.getAllRecords();
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
                ObservableList<Zemployee> empList = b.employee.searchEmployee(employeeId);

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
