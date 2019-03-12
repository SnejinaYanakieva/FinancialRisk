/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;

/**
 *The result of a cash flow.
 * @author Viktor
 */
public enum CashFlowResult implements CalculationResult {
    INTEREST_PAYMENTS,
    AMORTITATION_PAYMENT;

    @Override
    public String getName() {
        return name();
    }

}
