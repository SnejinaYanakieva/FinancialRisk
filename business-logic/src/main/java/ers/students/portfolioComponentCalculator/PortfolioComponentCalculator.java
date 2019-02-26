/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ers.students.portfolioComponentCalculator;

import java.util.Date;

import ers.students.market.Market;
import ers.students.pfc.AbstractPfc;

/**
 *
 * @author Irina
 */
public interface PortfolioComponentCalculator {
    
	void calculatePresentValue(AbstractPfc pfc, Market market, Date evalDate);

    void calculateProfitLoss(AbstractPfc pfc, Market market, Date evalDate);

    void calculatePositionVolume(AbstractPfc pfc, Market market, Date evalDate);

    void calculateCashFlow(AbstractPfc pfc, Market market, Date evalDate);
}