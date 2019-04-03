/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.util.Currency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 * @author tester
 */
public class InstrumentTest extends TestCase {

    public InstrumentTest(String testName) {
        super(testName);
    }

    /**
     * Test of validate method, of class Instrument.
     */
    public void testForNull() {
        //  System.out.println("validate");
        Instrument instance = new Instrument();
        List<String> expResult = new ArrayList<>();
        expResult.add("Id is invalid");
        expResult.add("Isin is invalid");
        expResult.add("Currency is null");
        expResult.add("Issue Date is null");
        expResult.add("Maturity Date is invalid");
        List<String> result = instance.validate();

        //Sorting 
        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

}
