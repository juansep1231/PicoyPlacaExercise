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
 * Class to manage date and time logic and validations.
 * @author Juan Posso
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
    
    /**
     * Method to check if time if in a given range
     * 
     * @param startTimeStr the start time of range
     * @param endTimeStr   the end time of a range
     * @param timeToCheckInput the time that you would like
     *        to check if is in the given range
     * @return true if the time to check is in the range, otherwise false
     */
    public boolean checkTimeRange(String startTimeStr, 
        String endTimeStr, String timeToCheckInput){
        
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);
        LocalTime timeToCheck = LocalTime.parse(timeToCheckInput);

        return !timeToCheck.isBefore(startTime) &&
                !timeToCheck.isAfter(endTime);
          
    }
    
  
    
    /**
     * Method to get the day's name, given a date.
     * 
     * @return the day's name that correspond to the given date
     */
    
     public String getDayOfTheWeek(){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.DATE_FORMAT);
        LocalDate dateFormat = LocalDate.parse(this.date, formatter); 
        String dayName = dateFormat.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        return dayName;
        
    }
    
    
    /**
     * Method to get the day index of an especific day 
     * using an array of days obtained from the enum.
     * 
     * @param dayOfTheWeek the day's name
     * @return the index that corresponds to the day's name
     */
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
   
   
      /**
     * Method to check if the day index corresponds to a weekend
     * @param dayIndex the index of the given day
     * @return true if the index corresponds to a weekend, otherwise false
     */
    public boolean checkWeekend(int dayIndex){
        return dayIndex == 5 || dayIndex == 6;
    }
   
    
    /**
     * 
     * Method to check if the input date is in the format "dd/MM/yyyy"
     * @return true if the given date has a valid format, otherwise false.
     * @throws InvalidDateException 
     */
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
    
     /**
      * Method to check if the input date is in the format "HH:mm"
      * @return true if the given time has a valid format, otherwise false.
      * @throws InvalidTimeException 
      */
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
