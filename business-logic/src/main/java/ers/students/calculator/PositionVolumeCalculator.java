/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculator;

import java.util.Date;

import ers.students.market.Market;
import ers.students.portfolio.component.PortfolioComponent;

/**
 * The PositionVolumeCalculator class is a class that provides method for
 * calculating the volume.
 *
 * @author Irina
 */
public class PositionVolumeCalculator implements Calculator {

    /**
     *
     * @param portfolioComponent component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculate(PortfolioComponent portfolioComponent, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }
}
