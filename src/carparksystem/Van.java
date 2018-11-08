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
public class Van extends Vehicle {

    private int cargoVolume;

    public Van(int cargovolume, int platenumber, String brand, DateTime datetime, String color) {
        super(platenumber, brand, datetime, color);
        this.cargoVolume = cargovolume;

    }

    public void setcargoVolume(int cargovolume) {
        this.cargoVolume = cargovolume;
    }

    public int getcargoVolume() {
        return cargoVolume;
    }

    public String getVehicleSpecifics() {
        return "The vehicle cargo volume is: " + cargoVolume;
    }

    public String whatVehicle() {
        return "Van";
    }

    public String whatcolor() {
        return color;
    }

}
