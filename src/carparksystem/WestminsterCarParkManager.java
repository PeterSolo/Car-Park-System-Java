/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparksystem;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collections;

/**
 * @author w1597188
 *
 */
public class WestminsterCarParkManager implements CarParkManager {

    private ArrayList<Vehicle> vehicleList;
    private int numOfVehicles;

    Scanner input = new Scanner(System.in);

    public WestminsterCarParkManager(int listLength) {
        numOfVehicles = listLength;
        vehicleList = new ArrayList<Vehicle>();

    }

    
    
    
    public void addVehicle(Vehicle V) {
        // checking if there is free space

        if (vehicleList.size() < numOfVehicles) {
            vehicleList.add(V);
            numOfVehicles--;
            if (V.whatVehicle().equals("Van")) {
                numOfVehicles--;  // decrementing more as it is van
            }

            System.out.println("the number of free lots left is :" + numOfVehicles);
        } else {
            System.out.println("There is no free parking lot left");
        }

    }

    
    
    public void printVehicleList() {
        if (vehicleList.size() == 0) {
            System.out.println("No vehicle in the parking lot");
        } else {
            for (int i = 0; i < vehicleList.size(); i++) {

                System.out.println("Vehicle= " + vehicleList.get(i).whatVehicle() + " PlateNumber= " + vehicleList.get(i).getplateNumber() + " and time entered is : " + vehicleList.get(i).getdateandtime());
            }
        }
        
        System.out.println("In orderlist form");
        Collections.sort(vehicleList);     // sorting based on date of entrance
        for (Vehicle str : vehicleList) {
            System.out.println(str);
        }
    }

    public void deletVehicle(int plateN) {

        for (int j = 0; j < vehicleList.size(); j++) {
            if (vehicleList.get(j).getplateNumber() == plateN) {
                if (vehicleList.get(j).whatVehicle().equals("Car")) {
                    System.out.println("The vehile leaving is car of color= " + vehicleList.get(j).getcolor());
                }
                if (vehicleList.get(j).whatVehicle().equals("Van")) {
                    System.out.println("The vehile leaving is van");
                    numOfVehicles++;     // incrementing more as it is a van 
                }
                if (vehicleList.get(j).whatVehicle().equals("Motorbike")) {
                    System.out.println("The vehile leaving is Motorbike");
                }
                vehicleList.remove(j);
                numOfVehicles++;
                System.out.println("the number of spaces left is : " + numOfVehicles);

            }

        }

    }

    
    
    
    
    public void printStatistics() {

        double carNP;
        double VanNP;
        double MotorbikeNP;
        double carN = 0;
        double VanN = 0;
        double MotorbikeN = 0;
        int listSize = vehicleList.size();
        if (listSize > 0) {                             // checking if parking is empty
            for (int j = 0; j < vehicleList.size(); j++) {
                if (vehicleList.get(j).whatVehicle().equals("Car")) {
                    carN++;
                } else if (vehicleList.get(j).whatVehicle().equals("Van")) {
                    VanN++;
                } else if (vehicleList.get(j).whatVehicle().equals("Motorbike")) {
                    MotorbikeN++;
                }
            }

            carNP = ((carN / listSize) * 100);      // finding percentage of each type of vehicle
            VanNP = ((VanN / listSize) * 100);
            MotorbikeNP = ((MotorbikeN / listSize) * 100);

            System.out.println("The percentage of cars : " + carNP);
            System.out.println("The percentage of Vans : " + VanNP);
            System.out.println("The percentage of Motorbikes : " + MotorbikeNP);
        } else {
            System.out.println("The parking is empty");
        }

        // sorting array to display longest and shortest
        long minH = 0, minM = 0;
        long minH1 = 1000000000, minM1 = 1000000000;
        int plate = 0, plate1 = 0;
        String type = "", type1 = "", date = "", date1 = "";
        int a, b, c, d, e;

        StringBuilder sb = new StringBuilder();
        String inttostring, currentDateTime;
        Date d1 = null;
        Date d2 = null;
        DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/mm/yy");
        Date dateS = new Date();
        currentDateTime = dateFormat.format(dateS); //2016/11/16 12:08:43
        for (int j = 0; j < vehicleList.size(); j++) {
            a = vehicleList.get(j).dateandtime.gethr();
            b = vehicleList.get(j).dateandtime.getmin();
            c = vehicleList.get(j).dateandtime.getdate();
            d = vehicleList.get(j).dateandtime.getmonth();
            e = vehicleList.get(j).dateandtime.getyear();

            sb.append(String.format("%02d", a));
            sb.append(":");
            sb.append(String.format("%02d", b));
            sb.append(" ");
            sb.append(String.format("%02d", c));
            sb.append("/");
            sb.append(String.format("%02d", d));
            sb.append("/");
            sb.append(String.format("%02d", e));
            inttostring = sb.toString();
            try {
                d1 = dateFormat.parse(inttostring);
                d2 = dateFormat.parse(currentDateTime);
            } catch (ParseException m) {
                m.printStackTrace();
            }
            long diff = d2.getTime() - d1.getTime();
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000);

            if (diffHours > minH) {        // if hours is morethan minH, the vehicle is the longest stayed for this 
                minH = diffHours;          // particular iteration(loop) 
                if (diffMinutes > minM) {
                    minM = diffMinutes;
                }
                date = inttostring;                     // details will be added at this iteration
                plate = vehicleList.get(j).plateNumber;
                type = vehicleList.get(j).whatVehicle();
            }
        }

        System.out.println("Vehicle that stayed longest type:" + type + " Plate number: " + plate + " Time entered: " + date);

        for (int j = 0; j < vehicleList.size(); j++) {
            a = vehicleList.get(j).dateandtime.gethr();
            b = vehicleList.get(j).dateandtime.getmin();
            c = vehicleList.get(j).dateandtime.getdate();
            d = vehicleList.get(j).dateandtime.getmonth();
            e = vehicleList.get(j).dateandtime.getyear();

            sb.append(String.format("%02d", a));
            sb.append(":");
            sb.append(String.format("%02d", b));
            sb.append(" ");
            sb.append(String.format("%02d", c));
            sb.append("/");
            sb.append(String.format("%02d", d));
            sb.append("/");
            sb.append(String.format("%02d", e));
            inttostring = sb.toString();
            try {
                d1 = dateFormat.parse(inttostring);
                d2 = dateFormat.parse(currentDateTime);
            } catch (ParseException m) {
                m.printStackTrace();
            }
            long diff = d2.getTime() - d1.getTime();
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000);
            if (diffHours < minH1) {                     // same process like above but in opposite way
                minH1 = diffHours;
                if (diffMinutes < minM1) {

                    minM1 = diffMinutes;
                }
                date1 = inttostring;
                plate1 = vehicleList.get(j).plateNumber;    // details added at this iteration
                type1 = vehicleList.get(j).whatVehicle();
            }
        }

        System.out.println("Vehicle that parked recently type:" + type1 + " Plate number: " + plate1 + " Time entered: " + date1);
    }

    
    
    
    public void vehicleListSpecificDate(int DATE, int MONTH, int YEAR) {
        int count = 0;
        for (int k = 0; k < vehicleList.size(); k++) {
            if ((vehicleList.get(k).dateandtime.getdate() == DATE) && (vehicleList.get(k).dateandtime.getmonth() == MONTH) && (vehicleList.get(k).dateandtime.getyear() == YEAR)) { // checking date to find the vehicle in each iteration
                count++;
                System.out.println("Vehicle: " + vehicleList.get(k).whatVehicle() + " Plate number: " + vehicleList.get(k).getplateNumber());
            }

        }
        if (count == 0) {
            System.out.println("No vehicles parked on this date");
        }

    }

    public void printcharges() throws IOException {
         
          String inttostring, currentDateTime;
        DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/mm/yy");
        Date date = new Date();
        currentDateTime = dateFormat.format(date); // 12:08 16/11/16
        for (int j = 0; j < vehicleList.size(); j++) {
          StringBuilder sb = new StringBuilder();
         
          int a, b, c, d, e;
        Date d1 = null;
        Date d2 = null; 
            
            a = vehicleList.get(j).dateandtime.gethr();
            b = vehicleList.get(j).dateandtime.getmin();
            c = vehicleList.get(j).dateandtime.getdate();
            d = vehicleList.get(j).dateandtime.getmonth();
            e = vehicleList.get(j).dateandtime.getyear();

            sb.append(String.format("%02d", a));
            sb.append(":");
            sb.append(String.format("%02d", b));
            sb.append(" ");                              // getting date and time and appending it in 
            sb.append(String.format("%02d", c));         // a string to compare it with current time
             sb.append("/");
            sb.append(String.format("%02d", d));
            sb.append("/");
            sb.append(String.format("%02d", e));
            inttostring = sb.toString();
            try {
                d1 = dateFormat.parse(inttostring);
                d2 = dateFormat.parse(currentDateTime);
            } catch (ParseException m) {
                m.printStackTrace();
            }
            long diff = d2.getTime() - d1.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);        // getting the difference between the two times and date
            long diffHours = diff / (60 * 60 * 1000);
            double charge=0.0;
            long difference1, difference2;
            charge = (30 * diffDays);
            difference2 = (diffHours - (24 * diffDays));        // calculating the charge based on the difference of time and date
            if (difference2 > 3) {
                charge = charge + 9;
                difference1 = (difference2 - 3);
                charge = (charge + (difference1 * 4));
            } else {
                charge = (charge + 9);
            }

            System.out.println("Vehicle with plate number: " + vehicleList.get(j).getplateNumber() + " Charge:£ " + charge);

        }

    }

    public void findprobablity() {
        // the formula for the poisson is p(x,lambda)=(lambda power x *e power -lmbda)/x!
        double lambda = 27; //addition of both entrances  
        int x = 0;// ranges 1 to 10
        double probablity1, probablity2, probablityF, probablitytoP = 0;
        for (int i = 0; i < 10; i++) {
            x = i;
            probablity1 = ((Math.pow(lambda, x)) * (Math.pow(Math.E, -lambda)));
            probablity1 = factorial(x);
            probablityF = (probablity1 / probablity1);
            probablitytoP = probablitytoP + probablityF;
        }
        System.out.println(probablitytoP + " %");

    }

    public int factorial(int iNo) {

        // Make sure that the input argument is positive
        if (iNo < 0) {
            throw new IllegalArgumentException("iNo must be >= 0");
        }

        // Use simple look to compute factorial....
        int factorial = 1;
        for (int i = 2; i <= iNo; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public boolean runMenu() {
        int PlateNumber;
        String brand;
        int doorNum;
        int cargo;
        int eSize;
        int hr, min, date, month, year;
        boolean exit = false;

        System.out.println("1 To add vehicle \n"
                + "2 To delete a vehicle\n"
                + "3 To Print the vehicles in the list\n"
                + "4 To print the Statistics of the parking \n"
                + "5 To print vehicle list that entered on specific date\n"
                + "6 To print the current charges of parked vehicles\n"
                + "7 To print the probablity of 10 vehicles parked\n"
                + "8 To exit program");

        int option = input.nextInt();
        switch (option) {

            case 1:
                System.out.println("Please enter the plate number");
                PlateNumber = input.nextInt();
                System.out.println("Please enter the make of the vehicle");   // using switch to select what the user wants to do 
                brand = input.next();
                System.out.println("Please enter hr in two digits");
                hr = input.nextInt();
                System.out.println("Please enter mins in two digits");
                min = input.nextInt();
                System.out.println("Please enter date in two digits");
                date = input.nextInt();
                System.out.println("Please enter month in two digits");
                month = input.nextInt();
                System.out.println("Please enter year in two digits");
                year = input.nextInt();
                                                                                     
                System.out.println("Please enter what vehicle you want to enter ");      // using switch implementing the choice
                String name = input.next();

                if (name.equalsIgnoreCase("Car")) {
                    System.out.println("Please enter how many doors its got ");
                    doorNum = input.nextInt();
                    System.out.println("Please enter the colour of the car");
                    String color = input.next();
                    DateTime entryTime = new DateTime(hr, min, date, month, year);
                    Car c = new Car(doorNum, PlateNumber, brand, entryTime, color);

                    this.addVehicle(c);
                }
                                                                                         // using if to differentiate between types of vehicles 
                if (name.equalsIgnoreCase("Van")) {
                    System.out.println("Please enter what is the cargo volume ");
                    cargo = input.nextInt();
                    System.out.println("Please enter the colour of the Van");
                    String color = input.next();
                    DateTime entryTime = new DateTime(hr, min, date, month, year);
                    Van v = new Van(cargo, PlateNumber, brand, entryTime, color);
                    this.addVehicle(v);
                }

                if (name.equalsIgnoreCase("Motorbike")) {
                    System.out.println("Please enter what is the engine size ");
                    eSize = input.nextInt();
                    System.out.println("Please enter the colour of the Motorbike");
                    String color = input.next();
                    DateTime entryTime = new DateTime(hr, min, date, month, year);
                    Motorbike m = new Motorbike(eSize, PlateNumber, brand, entryTime, color);
                    this.addVehicle(m);
                }
                break;

            case 2:
                if (vehicleList.size() == 0) {
                    System.out.println("No vehicle in the parking lot");
                } else {
                    System.out.println("Please enter the plate number of vehicle you want to delete");
                    PlateNumber = input.nextInt();
                    this.deletVehicle(PlateNumber);
                }
                break;

            case 3:
                this.printVehicleList();
                break;

            case 4:
                this.printStatistics();
                break;

            case 5:
                System.out.println("Please enter the date of the day that you want to see vehicles parked on that date");
                date = input.nextInt();
                System.out.println("month");
                month = input.nextInt();
                System.out.println("Year");
                year = input.nextInt();
                this.vehicleListSpecificDate(date, month, year);
                break;

            case 6: {
                try {
                    this.printcharges();
                } catch (IOException ex) {
                    Logger.getLogger(WestminsterCarParkManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 7:
                findprobablity();

                break;

            case 8:
                exit = true;
                break;

        }

        return exit;
    }

    public static void main(String args[]) {

        // creating parking 
        CarParkManager Park = new WestminsterCarParkManager(20);
        boolean exit = false;
        while (!exit) {
            exit = Park.runMenu();
        }
    }

}
