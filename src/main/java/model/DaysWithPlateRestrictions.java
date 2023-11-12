/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Juan Posso
 */
public enum DaysWithPlateRestrictions {
    
    MONDAY(Arrays.asList(1,2)),
    TUESDAY(Arrays.asList(3,4)),
    WEDNESDAY(Arrays.asList(5,6)),
    THURSDAY(Arrays.asList(7,8)),
    FRIDAY(Arrays.asList(9,0)),
    SATURDAY(),
    SUNDAY();
    
    
    private List<Integer> listOfRestrictions;
    
    private DaysWithPlateRestrictions(List<Integer> listOfRestrictions) {
        this.listOfRestrictions = listOfRestrictions;
    }

    private DaysWithPlateRestrictions() {
    }
    
    
    public List<Integer> getListOfRestrictions() {
        return listOfRestrictions;
    }
    
    
    
}
