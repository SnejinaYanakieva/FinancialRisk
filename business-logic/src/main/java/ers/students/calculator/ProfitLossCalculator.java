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
 * The ProfitLossCalculator class is a class that provides method for
 * calculating the profit and loss from an investment. The profit and loss (P&L)
 * statement is a financial statement which summarizes the revenue and costs
 * incurred during a specified period.
 *
 * @author Irina
 */
public class ProfitLossCalculator implements Calculator {

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
