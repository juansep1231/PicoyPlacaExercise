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
public class Car {
    private String carPlate;

    public Car(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
    
    private int getLastDigitOfThePlate(){
        //TO DO: Implement method
        
        return 0;
    }
}
