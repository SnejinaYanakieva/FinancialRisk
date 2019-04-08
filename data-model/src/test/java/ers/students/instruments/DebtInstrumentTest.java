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

/**
 *
 * @author Viktor
 */
public class DebtInstrumentTest extends TestCase {

    public DebtInstrumentTest(String testName) {
        super(testName);
    }

    /**
     * Test of validate method, of class DebtInstrument.
     */
    public void testValidate() {

       
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

}
