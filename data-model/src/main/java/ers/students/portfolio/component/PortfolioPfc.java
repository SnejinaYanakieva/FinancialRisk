/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;

import ers.students.portfolio.Portfolio;
import java.util.*;

/**
 *
 * @author Viktor
 */
public class PortfolioPfc extends AbstractPfc {

    private Portfolio portfolio;
    private List<PortfolioComponent> elements = new ArrayList();

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;

    }

    public List<PortfolioComponent> getElements() {
        return elements;
    }

    public void addElements(PortfolioComponent elements) {
        this.elements.add(elements);
    }

}
