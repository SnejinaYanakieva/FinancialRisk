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
