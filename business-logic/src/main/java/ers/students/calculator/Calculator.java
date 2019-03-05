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
 * The interface provides calculation method for each class that implements it.
 *
 * @author Irina
 */
public interface Calculator {

    /**
     *
     * @param portfolioComponent the component used to group positions
     * @param market provides information about the market yield of financial
     * instruments
     * @param evalDate
     */
    public void calculate(PortfolioComponent portfolioComponent, Market market, Date evalDate);
}
