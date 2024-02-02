package com.example.sda_project23;

import BL.BakeryControllor;
import BL.ZbakeryItem;
import BL.ZbakeryItem;
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

public class A31bakeryItemsControllor
{
    @FXML
    private TableView E_table;

    @FXML
    private Button add;

    @FXML
    private Button backArrow;

    @FXML
    private Button delete;

    @FXML
    private TextField discount;

    @FXML
    private TableColumn<ZbakeryItem, Integer> discount1;

    @FXML
    private Button exit;

    @FXML
    private TextField id;

    @FXML
    private TableColumn<ZbakeryItem, Integer> id1;

    @FXML
    private TextField name;

    @FXML
    private TableColumn<ZbakeryItem, String> name1;

    @FXML
    private TextField price;

    @FXML
    private TableColumn<ZbakeryItem, Integer> price1;

    @FXML
    private TextField quantity;

    @FXML
    private TableColumn<ZbakeryItem, Integer> quantity1;

    @FXML
    private TextArea resultConsole;

    @FXML
    private Button search;

    @FXML
    private Button update;

    @FXML
    private Button view;

    private Stage stage;
    private Scene scene;
    private Parent root;
    BakeryControllor b = new BakeryControllor();


    // ---------- 1. INSERT SALES ----------
    @FXML
    void onAdd(ActionEvent event)
    {
        String id1 = id.getText().trim(); // Trim to remove leading/trailing whitespaces
        String budget1 =price.getText().trim(); // Trim to remove leading/trailing whitespaces
        String month1 = name.getText().trim(); // Trim to remove leading/trailing whitespaces
        String year1 = quantity.getText().trim(); // Trim to remove leading/trailing whitespaces
        String revenue1 = discount.getText().trim(); // Trim to remove leading/trailing whitespaces

        if (!id1.isEmpty())
        {
            try {
                int id2 = Integer.parseInt(id1);
                int budget2 = Integer.parseInt(budget1);
                int year2=  Integer.parseInt(year1);
                int revenue2=  Integer.parseInt(revenue1);

                // Now 'employeeId' is the integer value of the text
                b.inventory.bakeryItems.addSales(id2, budget2, revenue2, month1, year2);
                ObservableList<ZbakeryItem> empList= b.inventory.bakeryItems.getAllRecords();
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
                b.inventory.bakeryItems.deleteSales(id2);
                ObservableList<ZbakeryItem> empList= b.inventory.bakeryItems.getAllRecords();
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
                b.inventory.bakeryItems.searchsales(id2);
                ObservableList<ZbakeryItem> empList= b.inventory.bakeryItems.getAllRecords();
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
        String budget1 =price.getText().trim(); // Trim to remove leading/trailing whitespaces
        String month1 = name.getText().trim(); // Trim to remove leading/trailing whitespaces
        String year1 = quantity.getText().trim(); // Trim to remove leading/trailing whitespaces
        String revenue1 = discount.getText().trim(); // Trim to remove leading/trailing whitespaces

        if (!id1.isEmpty())
        {
            try {
                int id2 = Integer.parseInt(id1);
                int budget2 = Integer.parseInt(budget1);


                // Now 'employeeId' is the integer value of the text
                b.inventory.bakeryItems.updateSales(id2, budget2);
                ObservableList<ZbakeryItem> empList= b.inventory.bakeryItems.getAllRecords();
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
    public void populateTable( ObservableList<ZbakeryItem> empList)
    {
        E_table.setItems(empList);
    }
    @FXML
    public void initialize(ActionEvent event) throws Exception
    {
        // Setting values in columns of table
        id1.setCellValueFactory(cellData->cellData.getValue().idProperty().asObject());
        quantity1.setCellValueFactory(cellData->cellData.getValue().quantityProperty().asObject());
        price1.setCellValueFactory(cellData->cellData.getValue().priceProperty().asObject());
        name1.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        discount1.setCellValueFactory(cellData->cellData.getValue().discountProperty().asObject());

        // Making list to populate the entire table with above columns
        ObservableList<ZbakeryItem> empList= b.inventory.bakeryItems.getAllRecords();
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
