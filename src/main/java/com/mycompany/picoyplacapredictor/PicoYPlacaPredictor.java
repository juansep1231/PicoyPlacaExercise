/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.picoyplacapredictor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class PicoYPlacaPredictor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            boolean flag = checkValidTime();
            System.out.println("buenisima");
                    } catch (ParseException ex) {
            System.out.println("mala fecha");
        }
    }
    public static boolean checkValidTime() throws ParseException{
        
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setLenient(false); // Setting lenient to false to strictly validate the date
        timeFormat.parse("5:00");
        return true;
        
     
    }
}
