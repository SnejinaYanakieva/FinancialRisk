/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.pfc;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.component.PortfolioComponent;
import java.util.*;
/**
 *
 * @author Viktor
 */
public class PortfolioPfc {
    private Portfolio portfolio;
    private List<PortfolioComponent> elements;


		public Portfolio getPortfolio() {
			return portfolio;
		}
		public void setPortfolio(Portfolio portfolio) {
			this.portfolio = portfolio;
		}
		public List<PortfolioComponent> getElements() {
			return elements;
		}
		public void setElements(List<PortfolioComponent> elements) {
			this.elements = elements;
		}

}
