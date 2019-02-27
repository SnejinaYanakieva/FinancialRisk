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
 *
 * @author Irina
 */
public class PositionCalculator implements PortfolioComponentCalculator {

    @Override
    public void calculatePresentValue(AbstractPfc pfc, Market market, Date evalDate)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Unsupported exception.");
    }

    @Override
    public void calculateProfitLoss(AbstractPfc pfc, Market market, Date evalDate)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Unsupported exception.");
    }

    @Override
    public void calculatePositionVolume(AbstractPfc pfc, Market market, Date evalDate)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Unsupported exception.");
    }

    @Override
    public void calculateCashFlow(AbstractPfc pfc, Market market, Date evalDate) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

}
