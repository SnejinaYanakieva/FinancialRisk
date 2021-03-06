/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculator.test;

import ers.students.calculation.provider.CalculationProvider;
import ers.students.calculation.provider.CalculationRequest;
import ers.students.calculation.provider.PfcCalculationResult;
import ers.students.crud.utils.SuccessfulPersistenceStore;
import ers.students.instruments.Credit;
import ers.students.instruments.Deposit;
import ers.students.instruments.Instrument;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import ers.students.portfolio.component.CalculationResult;
import ers.students.portfolio.component.DoubleResult;
import ers.students.util.Currency;
import ers.students.util.Frequency;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;

/**
 *
 * @author Irina
 */
public class PositionVolumeCalculationTest extends TestCase {

    private Calendar today = Calendar.getInstance();
    private Position position1 = new Position();
    private Credit instrument1;
    private Position position2 = new Position();
    private Deposit instrument2;
    private Portfolio portfolio = new Portfolio("1l", "portfolio1", Currency.CHF);
    private List<Transaction> transactions1 = new ArrayList<>();
    private List<Transaction> transactions2 = new ArrayList<>();
    private CalculationProvider calculationProvider = new CalculationProvider(new SuccessfulPersistenceStore());

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        initializeCredit();
        initializePosition(position1, instrument1, "1l", "name1", "longSide1", "shortSide1");
        transactions1.add(new Transaction("1l", position1.getId(), position1.getLongSide(), position1.getShortSide(), new Date(119, 3, 5), 100));
        transactions1.add(new Transaction("2l", position1.getId(), position1.getShortSide(), position1.getLongSide(), new Date(119, 3, 6), 50));
        transactions1.add(new Transaction("3l", position1.getId(), position1.getLongSide(), position1.getShortSide(), new Date(119, 3, 7), 50));
        transactions1.add(new Transaction("4l", position1.getId(), position1.getShortSide(), position1.getLongSide(), new Date(119, 3, 8), 40));

        initializeDeposit();
        initializePosition(position2, instrument2, "2l", "name2", "longSide2", "shortSide2");
        transactions2.add(new Transaction("5l", position2.getId(), position2.getLongSide(), position2.getShortSide(), new Date(119, 3, 5), 100));
        transactions2.add(new Transaction("6l", position2.getId(), position2.getShortSide(), position2.getLongSide(), new Date(119, 3, 6), 50));
        
    }
    
    public void testPositionVolumeCalculator(){
        Map<Position, List<Transaction>> positionTransactions = new HashMap<>();
        positionTransactions.put(position1, transactions1);
        positionTransactions.put(position2, transactions2);
        calculationProvider.setPositionTransactions(positionTransactions);
        CalculationRequest calculationRequest = new CalculationRequest(portfolio.getId(), Arrays.asList((CalculationResult)DoubleResult.POSITION_VOLUME), today);
        
        PfcCalculationResult calculationResult = calculationProvider.calculate(calculationRequest);
        
        assertTrue("You mustn't have errors.", calculationResult.getErrors().isEmpty());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    private void initializeCredit() {
        instrument1 = new Credit();
        instrument1.setId("1l");
        instrument1.setIsin("isin1");
        instrument1.setCurrency(Currency.CHF);
        instrument1.setIssueDate(today.getTime());
        Calendar maturity = (Calendar) today.clone();
        maturity.add(Calendar.YEAR, 10);
        instrument1.setMaturityDate(maturity.getTime());
        instrument1.setAmortitationFrequency(Frequency.MONTHLY);
        instrument1.setInterestFrequency(Frequency.QUATERLY);
        instrument1.setInterestRate(5);
    }

    private void initializeDeposit() {
        instrument2 = new Deposit();
        instrument2.setId("2l");
        instrument2.setIsin("isin2");
        instrument2.setCurrency(Currency.CHF);
        instrument2.setIssueDate(today.getTime());
        Calendar maturity = (Calendar) today.clone();
        maturity.add(Calendar.YEAR, 10);
        instrument2.setMaturityDate(maturity.getTime());
        instrument2.setInterestFrequency(Frequency.QUATERLY);
        instrument2.setInterestRate(5);
    }

    private void initializePosition(Position position, Instrument instrument, String id, String name, String longSide, String shortSide) {
        position.setInstrument(instrument);
        position.setId(id);
        position.setName(name);
        position.setPortfolioId("1l");
        position.setLongSide(longSide);
        position.setShortSide(shortSide);
    }
}
