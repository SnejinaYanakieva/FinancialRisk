/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculation.provider;

import ers.students.portfolio.component.AbstractPfc;
import ers.students.portfolio.component.PortfolioPfc;
import ers.students.portfolio.component.PositionPfc;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Irina
 */
public enum PortfolioComponentType {
    Portfolio,
    Position;

    public static Map<Class<? extends AbstractPfc>, PortfolioComponentType> portfolioComponentTypes = new HashMap();

    static {
        portfolioComponentTypes.put(PortfolioPfc.class, Portfolio);
        portfolioComponentTypes.put(PositionPfc.class, Position);
    }
}
