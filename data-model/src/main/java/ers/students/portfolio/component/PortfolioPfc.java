/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;

import ers.students.portfolio.Portfolio;
import java.util.*;

/**
 * PortfolioPfc is a portfolio component that have a variable portfolio and list
 * of portfolio components called elements
 *
 * @author Viktor
 */
public class PortfolioPfc extends AbstractPfc {

    private Portfolio portfolio;
    private final List<PortfolioComponent> elements = new ArrayList();

   public  PortfolioPfc(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

   public  PortfolioPfc() {
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;

    }

    public List<PortfolioComponent> getElements() {
        return elements;
    }

    public void addElement(PortfolioComponent element) {
        this.elements.add(element);
    }

}
