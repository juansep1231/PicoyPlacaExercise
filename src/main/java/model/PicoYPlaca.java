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
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Juan Posso
 */
public class PicoYPlaca {
    
    final String morningStartTime;
    final String morningEndTime; 
    final String nightStartTime;
    final String nightEndTime;
    
    private String date;
    private String time;
    private Car car;


    
    public PicoYPlaca(String date, String time, Car car) {
        this.date = date;
        this.time = time;
        this.car = car;
        this.morningStartTime = "07:00";
        this.morningEndTime = "09:30";
        this.nightStartTime = "16:00";
        this.nightEndTime = "19:30";
    }

    
    
    
   
    public boolean checkPlateRestriction(){
        String day = getDayOfTheWeek();
        int dayIndex = getDayOfTheWeekIndex(day);
        int lastPlateNumber = getLastDigitOfThePlate();
        
        if(checkTimeRange(morningStartTime,morningEndTime,time)
                || checkTimeRange(nightStartTime, nightEndTime, time))
            return false;
        
        if(checkWeekend(dayIndex))
            return false;
        
        List<Integer> restrictedPlateNumbers = DaysWithPlateRestrictions.values()[dayIndex]
                .getListOfRestrictions();
        
        return restrictedPlateNumbers.contains(lastPlateNumber);
       
    }
    
    private boolean checkTimeRange(String startTimeStr, 
        String endTimeStr, String timeToCheckInput){
        
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);
        LocalTime timeToCheck = LocalTime.parse(timeToCheckInput);

        return !timeToCheck.isBefore(startTime) &&
                !timeToCheck.isAfter(endTime);
          
    }
    
    private boolean checkWeekend(int dayIndex){
        return dayIndex == 5 || dayIndex == 6;
    }
    
    
   private int getDayOfTheWeekIndex(String dayOfTheWeek){
        
      final DaysWithPlateRestrictions[] daysOfTheWeek = 
              DaysWithPlateRestrictions.values();
        
      for (int i = 0; i < daysOfTheWeek.length; i++) {
            if (daysOfTheWeek[i].name().equalsIgnoreCase(dayOfTheWeek)) {
                return i;
            }
        }
        return -1; 
    }
    
    private int getLastDigitOfThePlate(){
        
        return this.car.getCarPlate().charAt(this.car.getCarPlate().length() - 1);
        
    }
    
    private String getDayOfTheWeek(){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(this.date, formatter); 
        String dayName = date.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        return dayName;
        
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
    
    
    
    
}
