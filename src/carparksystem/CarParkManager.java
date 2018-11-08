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
public interface CarParkManager {

    // print vehivle
    //add vehicle
    //delete..
  
    public abstract void addVehicle(Vehicle V);
    public abstract void printVehicleList();
    public abstract void deletVehicle(int plateN);
    public abstract void printStatistics();
    public abstract void vehicleListSpecificDate(int DATE, int MONTH, int YEAR);
  
    public abstract void findprobablity();
    public abstract int factorial(int iNo);
    public abstract boolean runMenu();
    
    
    
    
    
    
    
    
    
    
}
