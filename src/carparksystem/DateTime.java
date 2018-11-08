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
public class DateTime {

    protected int hr;
    protected int min;
    protected int date;
    protected int month;
    protected int year;

    public DateTime() {
    }

    public DateTime(int hr, int min, int date, int month, int year) {

        this.hr = hr;
        this.min = min;
        this.date = date;
        this.month = month;
        this.year = year;

    }

    public void setTimeDate(DateTime dateTime) {
        this.hr = dateTime.hr;
        this.min = dateTime.min;
        this.date = dateTime.date;
        this.month = dateTime.month;
        this.year = dateTime.year;

    }

    public String getTimeDate() {
        return hr + ":" + min + "|" + date + "/" + month + "/" + year;
    }

    public int gethr() {
        return hr;
    }

    public int getmin() {
        return min;
    }

    public int getdate() {
        return date;
    }

    public int getmonth() {
        return month;
    }

    public int getyear() {
        return year;
    }

    public String toString() {
        return hr + ":" + min + "|" + date + "/" + month + "/" + year;
    }

}
