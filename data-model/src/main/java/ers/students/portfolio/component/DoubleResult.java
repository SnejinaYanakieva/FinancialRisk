/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;

/**
 * An enum that gives us the results of type double
 *
 * @author Viktor
 */
public enum DoubleResult implements CalculationResult {
    PV,
    PROFIT_LOSS,
    POSITION_VOLUME;

    @Override
    public String getName() {
        return name();
    }

}
