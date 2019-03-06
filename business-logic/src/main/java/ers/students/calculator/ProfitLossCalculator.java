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
