/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculator.pfc;

import java.util.Date;

import ers.students.market.Market;
import ers.students.portfolio.component.AbstractPfc;

/**
 * The PositionCalculator class is a class that provides methods for calculating
 * cash flow, present value, profit and loss, position volume.
 *
 * @author Irina
 */
public class PositionCalculator implements PortfolioComponentCalculator {

    /**
     * The Present Value is calculated by the formula:
     * Present Value = FV / ( 1 + r )^n, where 
     * FV = future value 
     * r = rate of return 
     * n = number of periods
     *
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculatePresentValue(AbstractPfc pfc, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * The Profit & Loss is calculated by the formula:
     * Profit / Loss = Present Value - Notional amount
     * 
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculateProfitLoss(AbstractPfc pfc, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * 
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculatePositionVolume(AbstractPfc pfc, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * The Cash Flow is calculated by the formula:
     * Beginning cash + projected inflows – projected outflows = Ending cash
     * 
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculateCashFlow(AbstractPfc pfc, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

}
