/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculator.pfc;

import ers.students.instrument.CreditCalculator;
import ers.students.instrument.InstrumentCalculator;
import ers.students.instrument.resolver.InstrumentCalculatorResolver;
import ers.students.instruments.Credit;
import ers.students.instruments.Instrument;
import java.util.Date;

import ers.students.market.Market;
import ers.students.portfolio.Transaction;
import ers.students.portfolio.component.CashFlowResult;
import ers.students.portfolio.component.DoubleResult;
import ers.students.portfolio.component.PortfolioComponent;
import ers.students.portfolio.component.PositionPfc;
import ers.students.util.Frequency;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The PositionCalculator class provides methods for calculating cash flow,
 * present value, profit and loss, position volume.
 *
 * @author Irina
 */
public class PositionCalculator implements PortfolioComponentCalculator {

    /**
     * The Present Value is calculated by the formula: 
     * Present Value = FV / ( 1+ r )^n, where 
     * FV = future value 
     * r = rate of return 
     * n = number of periods
     *
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculatePresentValue(PortfolioComponent pfc, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * The Profit & Loss is calculated by the formula: 
     * Profit / Loss = PresentValue - Notional amount
     *
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculateProfitLoss(PortfolioComponent pfc, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Calculates the amount of transactions.
     *
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculatePositionVolume(PortfolioComponent pfc, Market market, Date evalDate) {
        PositionPfc positionPfc = (PositionPfc) pfc;
        List<Transaction> trasactions = positionPfc.getTransactionList();

        double volume = 0.0;
        for (Transaction transaction : trasactions) {

            if (transaction.getDate().after(evalDate)) {
                continue;
            }

            if (positionPfc.getPosition().getLongSide().equals(transaction.getPayer())) {
                volume += transaction.getAmount();
            } else {
                volume -= transaction.getAmount();
            }
        }

        if (volume <= 0) {
            positionPfc.addError("Volume is not positive.");
            return;
        }

        positionPfc.setVolume(volume);
        positionPfc.addCalculationResult(DoubleResult.POSITION_VOLUME, volume);
    }

    /**
     * Calculates the interest and principal payments.
     *
     * The Cash Flow is calculated by the formula:
     * CFi = Ci . RDI where 
     * CFi value of cash flow 
     * Ci interest payment for the period 
     * RDi residual debt
     *
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculateCashFlow(PortfolioComponent pfc, Market market, Date evalDate) {
        PositionPfc positionPfc = (PositionPfc) pfc;
        Instrument instrument = positionPfc.getPosition().getInstrument();
        
        if (instrument instanceof Credit) {
            CreditCalculator creditCalculator = new CreditCalculator();
            ///////////////////
            positionPfc.setVolume(100);
            creditCalculator.buildCashFlow(instrument, positionPfc.getVolume(), market, evalDate);
            
            positionPfc.getCalculationResults().
                    put(CashFlowResult.AMORTITATION_PAYMENT, creditCalculator.getAmortizationPayments());
        }
        
        
    }
}
