/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.util.Currency;
import ers.students.util.Frequency;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Viktor
 */
public class CreditTest extends TestCase {

    public CreditTest(String testName) {
        super(testName);
    }

    /**
     * Test of validate method, of class Credit.
     */
    public void testValidate() {
      //  System.out.println("Validating");
        Credit instance = new Credit();
        List<String> expResult = new ArrayList<>();
        expResult.add("id is invalid");
        expResult.add("isin is invalid");
        expResult.add("currency is null");
        expResult.add("issueDate is null");
        expResult.add("maturityDate is invalid");
        expResult.add("interestFrequency is null");
        expResult.add("interestRate is null");

        List<String> result = instance.validate();
        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    public void testValidateSecound() throws ParseException {
        List<String> expResult = new ArrayList<>();
      //  System.out.println("ValidateSecound");
        Credit instance = new Credit();
        instance.setId("Test123");
        instance.setIsin("Test");

        instance.setInterestRate(222);
        expResult.add("interestRate is out of bound");
        //Date 
        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        String DateVariable = "2018-09-00";
        instance.setIssueDate(dateformatt.parse(DateVariable));
        DateVariable = "2015-09-15";
        instance.setMaturityDate(dateformatt.parse(DateVariable));
        expResult.add("maturityDate is invalid");
        //Enum
        instance.setInterestFrequency(Frequency.QUATERLY);
        instance.setAmortitationFrequency(Frequency.MONTHLY);
        instance.setCurrency(Currency.BGN);

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

      /*  System.out.println("Expected Result List Start Here :");
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
