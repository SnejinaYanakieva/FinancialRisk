/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.util;

/**
 *
 * @author Viktor
 */
public enum Frequency {
    MONTHLY(1, 1),
    TWO_MONTHS(1, 2),
    QUATERLY(1, 3),
    FOUR_MONTHS(1, 4),
    SEMI_ANUAL(1, 6),
    ANUAL(2, 1),
    TWO_YEARS(2, 2);

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
