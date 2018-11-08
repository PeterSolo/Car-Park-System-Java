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
public abstract class Vehicle implements Comparable<Vehicle> {

    protected int plateNumber;
    protected String brand;
    protected DateTime dateandtime;
    protected String color;

    public Vehicle() {
    }

    public Vehicle(int plateNumber, String brand, DateTime datetime, String color) {

        this.plateNumber = plateNumber;
        this.brand = brand;
        dateandtime = datetime;
        this.color = color;
    }

    public void setplateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setbrand(String brand) {
        this.brand = brand;
    }

    public int getplateNumber() {
        return plateNumber;
    }

    public String getbrand() {
        return brand;
    }

    public void setcolor(String color) {
        this.color = color;
    }

    public String getcolor() {
        return color;
    }

    public String getdateandtime() {
        return dateandtime.toString();
    }

    public DateTime getdateandtimeD() {
        return dateandtime;
    }

    public int compareTo(Vehicle V) {
        int x = 0;
        if (this.dateandtime.date > V.dateandtime.date) {
            x = -1;
        }
        if (this.dateandtime.date == V.dateandtime.date) {
            x = 0;
        }
        if (this.dateandtime.date < V.dateandtime.date) {
            x = 1;
        }
        return x;

    }

    public String toString() {
        return "The plate number for this vehicle: " + plateNumber + "and the make of this car is:  " + brand;
    }

    public abstract String getVehicleSpecifics();

    public abstract String whatVehicle();

    public abstract String whatcolor();

}
