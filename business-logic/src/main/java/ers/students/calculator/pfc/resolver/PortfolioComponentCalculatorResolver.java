/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculator.pfc.resolver;

import java.util.*;

import ers.students.calculator.pfc.PortfolioCalculator;
import ers.students.calculator.pfc.PortfolioComponentCalculator;
import ers.students.calculator.pfc.PositionCalculator;
import ers.students.portfolio.component.AbstractPfc;
import ers.students.portfolio.component.PortfolioPfc;
import ers.students.portfolio.component.PositionPfc;

/**
 * The PortfolioComponentCalculatorResolver class is a class that is based on
 * the Registry Design Pattern. It provides information about the portfolio
 * component calculators.
 *
 * @author Irina
 */
public class PortfolioComponentCalculatorResolver {

    /**
     * Contains PortfolioComponentCalculator objects by given AbstractPfc class.
     */
    private final static Map<Class<? extends AbstractPfc>, PortfolioComponentCalculator> portfolioComponentCalculators = new HashMap<Class<? extends AbstractPfc>, PortfolioComponentCalculator>();

    /**
     * Map initialization with Portfolio Component Calculators.
     */
    static {
        portfolioComponentCalculators.put(PortfolioPfc.class, new PortfolioCalculator());
        portfolioComponentCalculators.put(PositionPfc.class, new PositionCalculator());
    }

    /**
     *
     * @param pfcClass a key to search a portfolio component calculator.
     * @return by given key returns corresponding portfolio component calculator.
     */
    public PortfolioComponentCalculator getPfcCalculator(Class<? extends AbstractPfc> pfcClass) {
        return portfolioComponentCalculators.get(pfcClass);
    }
}
