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
    private DateTime dateAndTime;
    
    private Car car;


    
    public PicoYPlaca(Car car,DateTime dateAndTimeInput) {
        this.dateAndTime = dateAndTimeInput;
        this.car = car;
        this.morningStartTime = "07:00";
        this.morningEndTime = "09:30";
        this.nightStartTime = "16:00";
        this.nightEndTime = "19:30";
    }

    
    public boolean checkPlateRestriction(){
        if (checkRestrictedDay() || checkRestrictedTime()) {
            List<Integer> restrictedPlateNumbers = getRestrictionsForDay();
            int lastPlateNumber = getLastDigitOfThePlate();
            return restrictedPlateNumbers.contains(lastPlateNumber);
        }
        return false;
    }

    private boolean checkRestrictedDay() {
        String day = dateAndTime.getDayOfTheWeek();
        int dayIndex = dateAndTime.getDayOfTheWeekIndex(day);
        return dateAndTime.checkWeekend(dayIndex);
    }

    private boolean checkRestrictedTime() {
        boolean checkMorningRange = dateAndTime.
                checkTimeRange(morningStartTime,
                               morningEndTime, dateAndTime.getTime());
        
         boolean checkNightRange = dateAndTime.
                checkTimeRange(nightStartTime,
                               nightEndTime, dateAndTime.getTime());
        
        return checkMorningRange || checkNightRange;
                
    }

    private List<Integer> getRestrictionsForDay() {
        String day = dateAndTime.getDayOfTheWeek();
        int dayIndex = dateAndTime.getDayOfTheWeekIndex(day);
        return DaysWithPlateRestrictions.values()[dayIndex].getListOfRestrictions();
    }
    
    private int getLastDigitOfThePlate(){
        char lastDigitOfThePlate = this.car.getCarPlate().
                                   charAt(this.car.getCarPlate().length() - 1);
        return Character.getNumericValue(lastDigitOfThePlate);
    }
    
   
}
