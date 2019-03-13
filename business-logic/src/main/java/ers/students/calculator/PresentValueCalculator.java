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
 * The PresentValueCalculator class is a class that provides method for
 * calculating the Present Value which refers to the current value of a future
 * sum of money or stream of cash flows given a specified rate of return. A rate
 * of return (RoR) is the net gain or loss on an investment over a specified
 * time period, expressed as a percentage of the investment’s initial cost.
 *
 * @author Irina
 */
public class PresentValueCalculator implements Calculator {

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
