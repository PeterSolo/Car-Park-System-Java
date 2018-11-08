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
public class Car extends Vehicle {

    private int numberOfDoors;

    public Car(int numberOfDoors, int platenumber, String brand, DateTime datetime, String color) {   //String color, this.color=color;
        super(platenumber, brand, datetime, color);
        this.numberOfDoors = numberOfDoors;
    }

    public void setnumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getnumberOfDoors() {
        return numberOfDoors;
    }

    public String getVehicleSpecifics() {
        if (numberOfDoors == 3) {
            return "This car has 2 doors";
        } else {
            return "This car has 4 doors";
        }
    }

    public String whatVehicle() {
        return "Car";
    }

    public String whatcolor() {
        return color;
    }

}
