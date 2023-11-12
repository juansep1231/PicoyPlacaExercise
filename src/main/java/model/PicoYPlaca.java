/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.List;


/**
 *
 * @author Juan Posso
 */
public class PicoYPlaca {
    
    private final String MORNING_START_TIME;
    private final String MORNING_END_TIME; 
    private final String NIGHT_START_TIME;
    private final String NIGHT_END_TIME;
    private DateTime dateAndTime; 
    private Car car;
    
    public PicoYPlaca(Car car,DateTime dateAndTimeInput) {
        this.dateAndTime = dateAndTimeInput;
        this.car = car;
        this.MORNING_START_TIME = "07:00";
        this.MORNING_END_TIME = "09:30";
        this.NIGHT_START_TIME = "16:00";
        this.NIGHT_END_TIME = "19:30";
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
        String day = this.dateAndTime.getDayOfTheWeek();
        int dayIndex = this.dateAndTime.getDayOfTheWeekIndex(day);
        return this.dateAndTime.checkWeekend(dayIndex);
    }

    private boolean checkRestrictedTime() {
        boolean checkMorningRange = this.dateAndTime.
                checkTimeRange(this.MORNING_START_TIME,
                               this.MORNING_END_TIME, this.dateAndTime.getTime());
        
        boolean checkNightRange = this.dateAndTime.
                checkTimeRange(this.NIGHT_START_TIME,
                               this.NIGHT_END_TIME, this.dateAndTime.getTime());
        
        return checkMorningRange || checkNightRange;
                
    }

    private List<Integer> getRestrictionsForDay() {
        String day = this.dateAndTime.getDayOfTheWeek();
        int dayIndex = this.dateAndTime.getDayOfTheWeekIndex(day);
        return DaysWithPlateRestrictions.
               values()[dayIndex].getListOfRestrictions();
    }
    
    private int getLastDigitOfThePlate(){
        char lastDigitOfThePlate = this.car.getCarPlate().
                                   charAt(this.car.getCarPlate().length() - 1);
        return Character.getNumericValue(lastDigitOfThePlate);
    }
    
   
}
