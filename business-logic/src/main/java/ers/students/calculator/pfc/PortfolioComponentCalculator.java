/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculator.pfc;

import java.util.Date;

import ers.students.market.Market;
import ers.students.portfolio.component.PortfolioComponent;

/**
 * This interface imposes calculation methods for each class that implements it.
 *
 * @author Irina
 */
public interface PortfolioComponentCalculator {

    void calculatePresentValue(PortfolioComponent pfc, Market market, Date evalDate);

    void calculateProfitLoss(PortfolioComponent pfc, Market market, Date evalDate);

    void calculatePositionVolume(PortfolioComponent pfc, Market market, Date evalDate);

    void calculateCashFlow(PortfolioComponent pfc, Market market, Date evalDate);
}
