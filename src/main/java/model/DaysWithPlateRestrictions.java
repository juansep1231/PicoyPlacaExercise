
package model;

import java.util.Arrays;
import java.util.List;

/**
 * Enum that contains the days of the week, each one has a list of their corresponding
 * car plate restrictions, except for weekends.
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
