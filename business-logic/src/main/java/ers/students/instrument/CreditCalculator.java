/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instrument;

import ers.students.instruments.Credit;
import ers.students.instruments.Instrument;
import ers.students.market.Market;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Credit calculator is used to calculate the price of a credit offer.
 *
 * @author Irina
 */
public class CreditCalculator implements InstrumentCalculator {

    Map<Calendar, Double> amortizationPayments = new HashMap<>();

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
     * Represents the interest and principal payments.
     *
     * @param instrument a set of contractual terms
     * @param positionVolume amount of transactions
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void buildCashFlow(Instrument instrument, double positionVolume, Market market, Date evalDate) {
        Credit credit = (Credit) instrument;

        Date issueDate = credit.getIssueDate();
        Date maturityDate = credit.getMaturityDate();

        // 
        int life = maturityDate.getYear() - issueDate.getYear();
        List<String> errors = new ArrayList<>();

        calculateAmortizationPayments(
                credit,
                life,
                positionVolume,
                issueDate,
                maturityDate,
                errors);
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
       return amortizationPayments;
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

    private void calculateAmortizationPayments(Credit credit, int life, double volume, Date issueDate, Date maturityDate, List<String> errors) {
        int period = credit.getAmortitationFrequency().getPeriod();

        if (period > life) {
            errors.add("Period cannot be more than life.");
        }

        int numberPayments = 0;
        if (credit.getAmortitationFrequency().getType() == Calendar.YEAR) {
            numberPayments = life / period;
        } else {
            int months = 12 / credit.getAmortitationFrequency().getPeriod();
            numberPayments = life * months;
        }

        double amountPayments = volume / numberPayments;
        Calendar cal = Calendar.getInstance();
        cal.setTime(issueDate);

        for (int i = 1; i <= numberPayments; i++) {

            cal.add(credit.getAmortitationFrequency().getType(), period);

            Date date = cal.getTime();

            if (date.after(maturityDate)) {
                continue;
            }

            amortizationPayments.put(cal, amountPayments);
        }
    }

}
