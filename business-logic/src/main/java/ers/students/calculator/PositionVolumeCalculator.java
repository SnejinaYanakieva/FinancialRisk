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
 * calculating the volume which refers to the quantity of contracts traded in a
 * given period.
 *
 * @author Irina
 */
public class PositionVolumeCalculator implements Calculator {

    /**
     *
     * @param portfolioComponent provides information about investments held by
     * an investment company. It represents a group of financial assets.
     * @param market provides information about the market
     * @param evalDate
     */
    @Override
    public void calculate(PortfolioComponent portfolioComponent, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }
}
