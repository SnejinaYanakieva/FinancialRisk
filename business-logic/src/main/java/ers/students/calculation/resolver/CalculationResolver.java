/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculation.resolver;

import ers.students.calculator.Calculator;
import ers.students.calculator.CashFlowCalculator;
import ers.students.calculator.PositionVolumeCalculator;
import ers.students.calculator.PresentValueCalculator;
import ers.students.calculator.ProfitLossCalculator;
import ers.students.portfolio.component.CashFlowResult;
import ers.students.portfolio.component.DoubleResult;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Irina
 */
public class CalculationResolver {

    private final static Map<String, Calculator> calculators = new HashMap<String, Calculator>();

    static {
        calculators.put(DoubleResult.POSITION_VOLUME.getName(), new PositionVolumeCalculator());
        calculators.put(CashFlowResult.AMORTITATION_PAYMENT.getName(), new CashFlowCalculator());
        calculators.put(CashFlowResult.INTEREST_PAYMENTS.getName(), new CashFlowCalculator());
        calculators.put(DoubleResult.PV.getName(), new PresentValueCalculator());
        calculators.put(DoubleResult.PROFIT_LOSS.getName(), new ProfitLossCalculator());
    }

    public static Calculator getCalculator(String calculationResultName) {
        return calculators.get(calculationResultName);
    }
}
