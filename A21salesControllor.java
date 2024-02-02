package com.example.sda_project23;

import BL.BakeryControllor;
import BL.Zemployee;
import BL.Zsales;
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

public class A21salesControllor
{

    @FXML
    private TableView E_table;

    @FXML
    private Button add;

    @FXML
    private Button backArrow;

    @FXML
    private TextField budget;

    @FXML
    private TableColumn<BL.Zsales, Integer> colBudget;

    @FXML
    private TableColumn<BL.Zsales, String> colMonth;

    @FXML
    private TableColumn<BL.Zsales, Integer> colRevenue;

    @FXML
    private TableColumn<BL.Zsales, Integer> colSales;

    @FXML
    private TableColumn<BL.Zsales, Integer> colYear;

    @FXML
    private Button delete;

    @FXML
    private Button exit;

    @FXML
    private TextField id;

    @FXML
    private TextField month;

    @FXML
    private TextArea resultConsole;

    @FXML
    private TextField revenue;

    @FXML
    private Button search;

    @FXML
    private Button update;

    @FXML
    private Button view;

    @FXML
    private TextField year;

    //
    private Stage stage;
    private Scene scene;
    private Parent root;
    BakeryControllor b = new BakeryControllor();


    // ---------- 1. INSERT SALES ----------
    @FXML
    void onAdd(ActionEvent event) 
    {
        String id1 = id.getText().trim(); // Trim to remove leading/trailing whitespaces
        String budget1 = budget.getText().trim(); // Trim to remove leading/trailing whitespaces
        String month1 = month.getText().trim(); // Trim to remove leading/trailing whitespaces
        String year1 = year.getText().trim(); // Trim to remove leading/trailing whitespaces
        String revenue1 = revenue.getText().trim(); // Trim to remove leading/trailing whitespaces

        if (!id1.isEmpty())
        {
            try {
                int id2 = Integer.parseInt(id1);
                int budget2 = Integer.parseInt(budget1);
                int year2=  Integer.parseInt(year1);
                int revenue2=  Integer.parseInt(revenue1);

                // Now 'employeeId' is the integer value of the text
                b.sales.addSales(id2, budget2, revenue2, month1, year2);
                ObservableList<Zsales> empList= b.sales.getAllRecords();
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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else
        {
            // Handle the case where the input is empty
            System.out.println("Please enter an Employee ID");
        }

    }


    // ----------- 3. DELETE SALES ----------
    @FXML
    void onDelete(ActionEvent event)
    {
        String id1 = id.getText().trim(); // Trim to remove leading/trailing whitespaces


        if (!id1.isEmpty())
        {
            try {
                int id2 = Integer.parseInt(id1);
                // Now 'employeeId' is the integer value of the text
                b.sales.deleteSales(id2);
                ObservableList<Zsales> empList= b.sales.getAllRecords();
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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else
        {
            // Handle the case where the input is empty
            System.out.println("Please enter an Employee ID");
        }


    }


    // ---------- SEARCH SALES  ----------
    @FXML
    void onSearch(ActionEvent event)
    {
        String id1 = id.getText().trim(); // Trim to remove leading/trailing whitespaces


        if (!id1.isEmpty())
        {
            try {
                int id2 = Integer.parseInt(id1);
                // Now 'employeeId' is the integer value of the text
                b.sales.searchsales(id2);
                ObservableList<Zsales> empList= b.sales.getAllRecords();
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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else
        {
            // Handle the case where the input is empty
            System.out.println("Please enter an Employee ID");
        }

    }

    // ---------- 2. UPDATE SALES ----------
    @FXML
    void onUpdate(ActionEvent event)
    {
        String id1 = id.getText().trim(); // Trim to remove leading/trailing whitespaces
        String budget1 = budget.getText().trim(); // Trim to remove leading/trailing whitespaces


        if (!id1.isEmpty())
        {
            try {
                int id2 = Integer.parseInt(id1);
                int budget2 = Integer.parseInt(budget1);


                // Now 'employeeId' is the integer value of the text
                b.sales.updateSales(id2, budget2);
                ObservableList<Zsales> empList= b.sales.getAllRecords();
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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else
        {
            // Handle the case where the input is empty
            System.out.println("Please enter an Employee ID");
        }

    }
    // --------------- DISPLAY --------------
    @FXML
    public void populateTable( ObservableList<Zsales> empList)
    {
        E_table.setItems(empList);
    }
    @FXML
    public void initialize(ActionEvent event) throws Exception
    {
        // Setting values in columns of table
        colSales.setCellValueFactory(cellData->cellData.getValue().idProperty().asObject());
        colBudget.setCellValueFactory(cellData->cellData.getValue().budgetProperty().asObject());
        colRevenue.setCellValueFactory(cellData->cellData.getValue().revenueProperty().asObject());
        colMonth.setCellValueFactory(cellData->cellData.getValue().monthProperty());
        colYear.setCellValueFactory(cellData->cellData.getValue().yearProperty().asObject());

        // Making list to populate the entire table with above columns
        ObservableList<Zsales> empList= b.sales.getAllRecords();
        populateTable(empList);
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
