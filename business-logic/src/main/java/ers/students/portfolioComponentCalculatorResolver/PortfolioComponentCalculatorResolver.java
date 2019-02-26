/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolioComponentCalculatorResolver;

import java.util.*;

import ers.students.portfolio.component.AbstractPfc;
import ers.students.portfolioComponentCalculator.PortfolioComponentCalculator;

/**
 *
 * @author Irina
 */
public class PortfolioComponentCalculatorResolver {

	private final static Map<AbstractPfc, PortfolioComponentCalculator> portfolioComponentCalculators = new HashMap<AbstractPfc, PortfolioComponentCalculator>();

	static {
		
	}

	public PortfolioComponentCalculator getPfcCalculator(Object object) throws UnsupportedOperationException {
		return null;
	}
}
