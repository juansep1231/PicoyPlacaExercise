/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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
    
    
    
    
   private int getDayOfTheWeekIndex(String dayOfTheWeek){
        
      final DaysWithPlateRestrictions[] daysOfTheWeek = DaysWithPlateRestrictions.values();
        
      for (int i = 0; i < daysOfTheWeek.length; i++) {
            if (daysOfTheWeek[i].name().equalsIgnoreCase(dayOfTheWeek)) {
                return i;
            }
        }
        return -1; 
    }
    
    
    
    private String getDayOfTheWeek(String dateInput){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date = LocalDate.parse(dateInput, formatter); // Parse the string to LocalDate

        String dayName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        return dayName;
        
    }
    
    
}
