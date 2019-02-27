/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculator.pfc.resolver;

import java.util.*;

import ers.students.calculator.pfc.PortfolioCalculator;
import ers.students.calculator.pfc.PortfolioComponentCalculator;
import ers.students.portfolio.component.AbstractPfc;
import ers.students.portfolio.component.PortfolioPfc;

/**
 *
 * @author Irina
 */
public class PortfolioComponentCalculatorResolver {

    private final static Map<Class<? extends AbstractPfc>, PortfolioComponentCalculator> portfolioComponentCalculators = new HashMap<Class<? extends AbstractPfc>, PortfolioComponentCalculator>();

    static {
        portfolioComponentCalculators.put(PortfolioPfc.class, new PortfolioCalculator());
        //portfolioComponentCalculators.put(PositionPfc.class, new PositionCalculator());
    }

    public PortfolioComponentCalculator getPfcCalculator(Object object) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Unsupported operation.");
    }
}
