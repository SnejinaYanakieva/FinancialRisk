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
import ers.students.portfolio.component.PortfolioComponent;
import ers.students.portfolio.component.PortfolioPfc;
import ers.students.portfolio.component.PositionPfc;

/**
 * The PortfolioComponentCalculatorResolver is a class that resolves by given
 * AbstractPfc class corresponding portfolio component calculator.
 *
 * @author Irina
 */
public class PortfolioComponentCalculatorResolver {

    /**
     * Contains PortfolioComponentCalculator objects by given corresponding
     * PortfolioComponent class.
     */
    private final static Map<Class<? extends PortfolioComponent>, PortfolioComponentCalculator> portfolioComponentCalculators = new HashMap<Class<? extends PortfolioComponent>, PortfolioComponentCalculator>();

    /**
     * Map initialization with Portfolio Component Calculators and corresponding
     * PortfolioComponent class.
     */
    static {
        portfolioComponentCalculators.put(PortfolioPfc.class, new PortfolioCalculator());
        portfolioComponentCalculators.put(PositionPfc.class, new PositionCalculator());
    }

    /**
     *
     * @param pfcClass a key to resolve a portfolio component calculator.
     * @return by given PortfolioComponent class key returns corresponding portfolio
     * component calculator.
     */
    public static PortfolioComponentCalculator getPfcCalculator(Class<? extends PortfolioComponent> pfcClass) {
        return portfolioComponentCalculators.get(pfcClass);
    }
}
