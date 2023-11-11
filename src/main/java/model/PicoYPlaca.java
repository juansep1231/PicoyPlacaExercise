/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Juan Posso
 */
public class PicoYPlaca {
    
    private String date;
    private String time;
    private int lastDigitOfCarPlate;

    public PicoYPlaca() {
    }

    
    public PicoYPlaca(String date, String time, int lastDigitOfCarPlate) {
        this.date = date;
        this.time = time;
        this.lastDigitOfCarPlate = lastDigitOfCarPlate;
    }

    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    private boolean checkCirculationPermit(){
        //TO DO: Implement method
        
        return true;
    }
}
