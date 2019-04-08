/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Viktor
 */
public class DebtInstrumentTest extends TestCase {

    /**
     * Test of validate method, of class DebtInstrument.
     */
    
    @Test
    public void testValidateNull() {

        DebtInstrument instance = new DebtInstrument();
        List<String> expResult = new ArrayList<>();
        expResult.add("Id is invalid");
        expResult.add("Isin is invalid");
        expResult.add("Currency is null");
        expResult.add("Issue Date is null");
        expResult.add("Maturity Date is invalid");
        expResult.add("Interest Frequency is null");
        List<String> result = instance.validate();

        //Sorting 
        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testValidateInterestRate() {

        DebtInstrument instance = new DebtInstrument();
        instance.setInterestRate(-200);
        List<String> expResult = new ArrayList<>();
        expResult.add("Id is invalid");
        expResult.add("Isin is invalid");
        expResult.add("Currency is null");
        expResult.add("Issue Date is null");
        expResult.add("Maturity Date is invalid");
        expResult.add("Interest Frequency is null");
        expResult.add("Interest Rate is out of bound");
        List<String> result = instance.validate();

        //Sorting 
        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }
}
