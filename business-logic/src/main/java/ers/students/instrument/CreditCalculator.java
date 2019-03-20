/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instrument;

import ers.students.instruments.Instrument;
import ers.students.market.Market;
import ers.students.portfolio.Position;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Irina
 */
public class CreditCalculator implements InstrumentCalculator {

    /**
     * 
     * @param instrument
     * @param positionVolume
     * @param market
     * @param evalDate
     * @return 
     */
    @Override
    public double calculatePresentValue(Instrument instrument, Position positionVolume, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @param instrument
     * @param positionVolume
     * @param market
     * @param evalDate 
     */
    @Override
    public void buildCashFlow(Instrument instrument, Position positionVolume, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @return 
     */
    @Override
    public Map<Calendar, Double> getInvestmentPayments() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @return 
     */
    @Override
    public Map<Calendar, Double> getAmortizationPayments() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @param instrument
     * @param positionVolume
     * @param market
     * @param evalDate
     * @return 
     */
    @Override
    public double calculateProfitLoss(Instrument instrument, Position positionVolume, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
