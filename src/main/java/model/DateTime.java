/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.InvalidDateException;
import exceptions.InvalidTimeException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private final String DATE_FORMAT;
    private final String TIME_FORMAT;
    private String date;
    private String time;

    public DateTime(String date, String time) {
        this.DATE_FORMAT = "dd/MM/yyyy";
        this.TIME_FORMAT = "HH:mm";
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
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.DATE_FORMAT);
        LocalDate dateFormat = LocalDate.parse(this.date, formatter); 
        String dayName = dateFormat.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        return dayName;
        
    }
    
    public boolean checkValidDateFormat() throws InvalidDateException{
        
        SimpleDateFormat timeFormat = new SimpleDateFormat(this.DATE_FORMAT);
        timeFormat.setLenient(false); // Setting lenient to false to strictly validate the date
        try{
        timeFormat.parse(this.date);
        return true; 
        } catch(ParseException e){
            throw new InvalidDateException("Invalid date format.");
        }
     
    }
    
     
     public boolean checkValidTimeFormat() throws InvalidTimeException{
        
        SimpleDateFormat timeFormat = new SimpleDateFormat(this.TIME_FORMAT);
        timeFormat.setLenient(false); // Setting lenient to false to strictly validate the date\
        try{
        timeFormat.parse(this.time);
        return true;
        }catch(ParseException e){
            throw new InvalidTimeException("Invalid time format.");
        }
        
    }
    public String getTime() {
        return time;
    }
    
    
}
