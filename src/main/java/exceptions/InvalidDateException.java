/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * Custom exception to handle and invalid time format.
 * @author Juan Posso
 */
public class InvalidDateException extends Exception {
    
    public InvalidDateException(String message) {
        super(message);
    }
   
}


