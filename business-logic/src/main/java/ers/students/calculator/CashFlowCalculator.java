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
 * The CashFlowCalculator class provides method for calculating cash flow. The
 * cash flow is a result of a signed contract.
 *
 * @author Irina
 */
public class CashFlowCalculator implements Calculator {

    /**
     * The Cash Flow is calculated by the formula:
     * CFi = Ci . RDI where
     * CFi value of cash flow 
     * Ci interest payment for the period 
     * RDi residual debt
     *
     * @param portfolioComponent component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculate(PortfolioComponent portfolioComponent, Market market, Date evalDate) {
        PortfolioComponentCalculator calculator = PortfolioComponentCalculatorResolver.getPfcCalculator(portfolioComponent.getClass());
        calculator.calculateCashFlow(portfolioComponent, market, evalDate);
    }

}
