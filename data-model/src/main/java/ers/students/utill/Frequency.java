/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.utill;

/**
 *
 * @author Viktor
 */

 public enum Frequency
{ 
    MONTHLY, TWO_MONTHS, QUATERLY, FOUR_MONTHS, SEMI_ANUAL, ANUAL, TWO_YEARS; 
    
    
    
private int type ;
private int period;



public int getType() {
        return type;
}
public void setType(int type) {
        this.type = type;
}


public int getPeriod() {
        return period;
}
public void setPeriod(int period) {
        this.period = period;
}
} 
/*public class Frequency(){


}*/