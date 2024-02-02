package BL;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Zkitchen
{
    private IntegerProperty id;
    private StringProperty status;
    private IntegerProperty request;

    // ---------- CONSTRUCTOR --------


    public Zkitchen()
    {
        this.id= new SimpleIntegerProperty();
        this.status= new SimpleStringProperty();
        this.request= new SimpleIntegerProperty();
        //this.salary= new SimpleIntegerProperty();
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

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public int getRequest() {
        return request.get();
    }

    public IntegerProperty requestProperty() {
        return request;
    }

    public void setRequest(int request) {
        this.request.set(request);
    }
}
