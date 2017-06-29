package hello;

import java.util.Calendar;

public class MyDataObject {

    private String name;

    public MyDataObject(String name) {
        this.name = name;
    }

    public MyDataObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}