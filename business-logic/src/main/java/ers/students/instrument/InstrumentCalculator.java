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
public interface InstrumentCalculator {
    
    double calculatePresentValue(Instrument instrument, Position positionVolume, Market market, Date evalDate);
    
    void buildCashFlow(Instrument instrument, Position positionVolume, Market market, Date evalDate);
    
    Map<Calendar, Double> getInvestmentPayments();
    
    Map<Calendar, Double> getAmortizationPayments();
    
    double calculateProfitLoss(Instrument instrument, Position positionVolume, Market market, Date evalDate);
}
