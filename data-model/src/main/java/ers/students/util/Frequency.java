/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.util;
import java.util.Calendar;
/**
 *
 * @author Viktor
 */
public enum Frequency {
    MONTHLY(Calendar.MONTH, 1),
    TWO_MONTHS(Calendar.MONTH, 2),
    QUATERLY(Calendar.MONTH, 3),
    FOUR_MONTHS(Calendar.MONTH, 4),
    SEMI_ANUAL(Calendar.MONTH, 6),
    ANUAL(Calendar.YEAR, 1),
    TWO_YEARS(Calendar.YEAR, 2);

    private int type;
    private int period;

    Frequency(int type, int period) {
        this.type = type;
        this.period = period;
    }

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
