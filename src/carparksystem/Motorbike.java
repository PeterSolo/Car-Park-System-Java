/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparksystem;

/**
 *
 * @author w1597188
 */
public class Motorbike extends Vehicle {

    private int engineSize;

    public Motorbike(int engineSize, int platenumber, String brand, DateTime datetime, String color) {
        super(platenumber, brand, datetime, color);
        this.engineSize = engineSize;

    }

    public void setengineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public int getengineSize() {
        return engineSize;
    }

    public String getVehicleSpecifics() {
        return "this motorbike's engine size is :" + engineSize;
    }

    public String whatVehicle() {
        return "Motorbike";
    }

    public String whatcolor() {
        return color;
    }
}
