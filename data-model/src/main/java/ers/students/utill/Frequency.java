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
public enum Frequency {
    MONTHLY("Calendar.Month", 1),
    TWO_MONTHS("Calendar.Month", 2),
    QUATERLY("Calendar.Month", 3),
    FOUR_MONTHS("Calendar.Month", 4),
    SEMI_ANUAL("Calendar.Month", 6),
    ANUAL("Calendar.Year", 1),
    TWO_YEARS("Calendar.Year", 2);

    private String type;
    private int period;

    Frequency(String type, int period) {
        this.type = type;
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
