/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.List;


/**
 *Class that contains a "Pico Y Placa" restriction.
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

    /**
     * Method to check if a car plate has circulation restriction on the given
     * date
     * 
     * @return true if the given plate has restriction on a given day,
     * otherwise false.
     */
    public boolean checkPlateRestriction(){
        if(checkWeekendRestriction())
            return false;
        if (checkRestrictedTime()) {
            List<Integer> restrictedPlateNumbers = getRestrictionsForDay();
            int lastPlateNumber = getLastDigitOfThePlate();
            return restrictedPlateNumbers.contains(lastPlateNumber);
        }
        return false;
    }

    /**
     * Method to check if a day is weekend.
     * 
     * @return true if a day is weekend, otherwise false.
     */
    private boolean checkWeekendRestriction() {
        String day = this.dateAndTime.getDayOfTheWeek();
        int dayIndex = this.dateAndTime.getDayOfTheWeekIndex(day);
        return this.dateAndTime.checkWeekend(dayIndex);
    }

    /**
     * Method to check if the given time is either in the morning restriction 
     * range or in the night restriction range.
     * 
     * @return true if the given time is in either of the two ranges, 
     * otherwise false.
     */
    private boolean checkRestrictedTime() {
        boolean checkMorningRange = this.dateAndTime.
                checkTimeRange(this.MORNING_START_TIME,
                               this.MORNING_END_TIME, this.dateAndTime.getTime());
        
        boolean checkNightRange = this.dateAndTime.
                checkTimeRange(this.NIGHT_START_TIME,
                               this.NIGHT_END_TIME, this.dateAndTime.getTime());
        
        return checkMorningRange || checkNightRange;
                
    }

    /**
     * Method to get the car plate restrictions for an especific day.
     * 
     * @return the list of plate restrictions from a given day
     */
    private List<Integer> getRestrictionsForDay() {
        String day = this.dateAndTime.getDayOfTheWeek();
        int dayIndex = this.dateAndTime.getDayOfTheWeekIndex(day);
        return DaysWithPlateRestrictions.
               values()[dayIndex].getListOfRestrictions();
    }
    
    /**
     * Method to get the last digit from a given car plate
     * @return the last digit of the car plate
     */
    private int getLastDigitOfThePlate(){
        char lastDigitOfThePlate = this.car.getCarPlate().
                                   charAt(this.car.getCarPlate().length() - 1);
        return Character.getNumericValue(lastDigitOfThePlate);
    }
    
   
}
