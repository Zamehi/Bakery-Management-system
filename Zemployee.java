package BL;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Zemployee
{
    private IntegerProperty id;
    private StringProperty name;
    private IntegerProperty salary;
    private IntegerProperty workHours;
    // ---------- CONSTRUCTOR --------


    public Zemployee()
    {
        this.id= new SimpleIntegerProperty();
        this.name= new SimpleStringProperty();
        this.workHours= new SimpleIntegerProperty();
        this.salary= new SimpleIntegerProperty();
    }



    // ----------- SETTER ------------
    public void setId(int id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

    public void setWorkHours(int workHours) {
        this.workHours.set(workHours);
    }


    // ----------- GETTER ------------


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getSalary() {
        return salary.get();
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    public int getWorkHours() {
        return workHours.get();
    }

    public IntegerProperty workHoursProperty() {
        return workHours;
    }
}
