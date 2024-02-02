package BL;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Zsales
{


    private IntegerProperty id;
    private IntegerProperty budget;
    private StringProperty month;
    private IntegerProperty revenue;
    private IntegerProperty year;


    public Zsales()
    {
        this.id= new SimpleIntegerProperty();
        this.month= new SimpleStringProperty();
        this.budget= new SimpleIntegerProperty();
        this.revenue= new SimpleIntegerProperty();
        this.year= new SimpleIntegerProperty();
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getBudget() {
        return budget.get();
    }

    public IntegerProperty budgetProperty() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget.set(budget);
    }

    public String getMonth() {
        return month.get();
    }

    public StringProperty monthProperty() {
        return month;
    }

    public void setMonth(String month) {
        this.month.set(month);
    }

    public int getRevenue() {
        return revenue.get();
    }

    public IntegerProperty revenueProperty() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue.set(revenue);
    }

    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }
}
