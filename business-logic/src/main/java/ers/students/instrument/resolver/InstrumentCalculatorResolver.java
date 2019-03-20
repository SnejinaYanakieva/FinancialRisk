/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instrument.resolver;

import ers.students.instrument.CreditCalculator;
import ers.students.instrument.DepositCalculator;
import ers.students.instrument.InstrumentCalculator;
import ers.students.instruments.Credit;
import ers.students.instruments.Deposit;
import ers.students.instruments.Instrument;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Irina
 */
public class InstrumentCalculatorResolver {

    private final static Map<Class<? extends Instrument>, InstrumentCalculator> instrumentCalculators = new HashMap<Class<? extends Instrument>, InstrumentCalculator>();
    
     static {
        instrumentCalculators.put(Credit.class, new CreditCalculator());
        instrumentCalculators.put(Deposit.class, new DepositCalculator());
    }
     
     public InstrumentCalculator getInstrumentCalculator(Class<? extends Instrument> instrumentClass) {
        return instrumentCalculators.get(instrumentClass);
    }
}
