package com.myapps.MyCars.data;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 7/13/14
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Car {
    private String model;

    public String getModel() {
        return model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    private String manufacture;
    private String name;
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
