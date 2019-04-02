/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.util.Frequency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author tester
 */
public class DebtInstrumentTest extends TestCase {

    public DebtInstrumentTest(String testName) {
        super(testName);
    }

    /**
     * Test of validate method, of class DebtInstrument.
     */
    public void testValidate() {

      //  System.out.println("validate");
        DebtInstrument instance = new DebtInstrument();
        List<String> expResult = new ArrayList<>();
        expResult.add("id is invalid");
        expResult.add("isin is invalid");
        expResult.add("currency is null");
        expResult.add("issueDate is null");
        expResult.add("maturityDate is invalid");
        expResult.add("interestFrequency is null");
        List<String> result = instance.validate();

        //Sorting 
        Collections.sort(expResult);
        Collections.sort(result);
/* 
        System.out.println("Expected Result List Start Here :");
        for (int i = 0; i < expResult.size(); i++) {
            System.out.println(expResult.get(i));
        }
        System.out.println();
        System.out.println("Result List Start Here :");

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
*/
        assertEquals(expResult, result);

    }

}
