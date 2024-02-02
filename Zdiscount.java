package BL;

import javafx.beans.property.*;

import java.sql.*;

public class Zdiscount
{

    private IntegerProperty productId;
    private IntegerProperty amount;
    private StringProperty startTime;
    private StringProperty endTime;

    public Zdiscount(IntegerProperty productId, IntegerProperty amount, StringProperty startTime, StringProperty endTime) {
        this.productId = productId;
        this.amount = amount;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Zdiscount()
    {
        this.productId= new SimpleIntegerProperty();
        this.amount= new SimpleIntegerProperty();
        this.endTime= new SimpleStringProperty();
        this.startTime= new SimpleStringProperty();
    }

    // ------------ GETTER AND SETTER --------------
    public int getProductId() {
        return productId.get();
    }

    public IntegerProperty productIdProperty() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId.set(productId);
    }

    public int getAmount() {
        return amount.get();
    }

    public IntegerProperty amountProperty() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }

    public String getStartTime() {
        return startTime.get();
    }

    public StringProperty startTimeProperty() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime.set(String.valueOf(startTime));
    }

    public String getEndTime() {
        return endTime.get();
    }

    public StringProperty endTimeProperty() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime.set(endTime);
    }
}
