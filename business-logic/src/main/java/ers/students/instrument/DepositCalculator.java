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
 * Deposit calculator is used to calculate the price of a deposit offer.
 *
 * @author Irina
 */
public class DepositCalculator implements InstrumentCalculator {

    /**
     * Calculates the discounted value of all incomes.
     *
     * @param instrument a set of contractual terms
     * @param positionVolume amount of transactions
     * @param market
     * @param evalDate date of calculation
     * @return present value
     */
    @Override
    public double calculatePresentValue(Instrument instrument, double positionVolume, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Represents the interest payments.
     *
     * @param instrument a set of contractual terms
     * @param positionVolume amount of transactions
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void buildCashFlow(Instrument instrument, double positionVolume, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @return pairs of corresponding date and investment payment
     */
    @Override
    public Map<Calendar, Double> getInvestmentPayments() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @return pairs of corresponding date and amortization payment
     */
    @Override
    public Map<Calendar, Double> getAmortizationPayments() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param instrument a set of contractual terms
     * @param positionVolume amount of transactions
     * @param market
     * @param evalDate date of calculation
     * @return profit/loss
     */
    @Override
    public double calculateProfitLoss(Instrument instrument, double positionVolume, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
