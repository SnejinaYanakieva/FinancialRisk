/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculator;

import ers.students.calculator.pfc.PortfolioComponentCalculator;
import ers.students.calculator.pfc.resolver.PortfolioComponentCalculatorResolver;
import java.util.Date;

import ers.students.market.Market;
import ers.students.portfolio.component.PortfolioComponent;

/**
 * The PresentValueCalculator class provides method for calculating the Present
 * Value.
 *
 * @author Irina
 */
public class PresentValueCalculator implements Calculator {

    /**
     * The Present Value is calculated by the formula: 
     * Present Value = FV / ( 1+ r )^n, where 
     * FV = future value 
     * r = rate of return 
     * n = number of periods
     *
     * @param portfolioComponent component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculate(PortfolioComponent portfolioComponent, Market market, Date evalDate) {
        PortfolioComponentCalculator calculator = PortfolioComponentCalculatorResolver.getPfcCalculator(portfolioComponent.getClass());
        calculator.calculatePresentValue(portfolioComponent, market, evalDate);
    }
}
