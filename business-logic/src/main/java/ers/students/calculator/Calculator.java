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
 * This interface imposes a calculation for each class that implements it.
 *
 * @author Irina
 */
public interface Calculator {

    public void calculate(PortfolioComponent portfolioComponent, Market market, Date evalDate);
}
