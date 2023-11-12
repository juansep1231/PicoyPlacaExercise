/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author juanc
 */
public class DateTime {
    private String date;
    private String time;

    public DateTime(String date, String time) {
        this.date = date;
        this.time = time;
    }
    
    
    
    public boolean checkTimeRange(String startTimeStr, 
        String endTimeStr, String timeToCheckInput){
        
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);
        LocalTime timeToCheck = LocalTime.parse(timeToCheckInput);

        return !timeToCheck.isBefore(startTime) &&
                !timeToCheck.isAfter(endTime);
          
    }
    
    public boolean checkWeekend(int dayIndex){
        return dayIndex == 5 || dayIndex == 6;
    }
    
    
    public int getDayOfTheWeekIndex(String dayOfTheWeek){

       final DaysWithPlateRestrictions[] daysOfTheWeek = 
               DaysWithPlateRestrictions.values();

       for (int i = 0; i < daysOfTheWeek.length; i++) {
             if (daysOfTheWeek[i].name().equalsIgnoreCase(dayOfTheWeek)) {
                 return i;
             }
         }
         return -1; 
     }
   
   
    
    public String getDayOfTheWeek(){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateFormat = LocalDate.parse(this.date, formatter); 
        String dayName = dateFormat.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        return dayName;
        
    }

    public String getTime() {
        return time;
    }
    
    
}
