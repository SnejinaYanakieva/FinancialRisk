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
import org.junit.Test;

/**
 *
 * @author Viktor
 */
public class CreditTest extends TestCase {

    @Test
    public void testForNull() {

        Credit instance = new Credit();
        List<String> expResult = new ArrayList<>();
        expResult.add("Id is invalid");
        expResult.add("Isin is invalid");
        expResult.add("Currency is null");
        expResult.add("Issue Date is null");
        expResult.add("Maturity Date is invalid");
        expResult.add("Interest Frequency is null");
        expResult.add("The amortization Frequency is null");

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testValidateInterestRate() throws ParseException {

        List<String> expResult = new ArrayList<>();
        Credit instance = new Credit();
        instance.setId("Test123");
        instance.setIsin("Test");
        instance.setInterestRate(222);
        expResult.add("Interest Rate is out of bound");
        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        String DateVariable = "2018-09-00";
        instance.setIssueDate(dateformatt.parse(DateVariable));
        DateVariable = "2019-09-15";
        instance.setMaturityDate(dateformatt.parse(DateVariable));
        instance.setInterestFrequency(Frequency.QUATERLY);
        instance.setAmortitationFrequency(Frequency.MONTHLY);
        instance.setCurrency(Currency.BGN);

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testValidateDate() throws ParseException {
        List<String> expResult = new ArrayList<>();
        //  System.out.println("ValidateSecound");
        Credit instance = new Credit();
        instance.setId("Test123");
        instance.setIsin("Test");
        instance.setInterestRate(3);
        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        String DateVariable = "2018-09-00";
        instance.setIssueDate(dateformatt.parse(DateVariable));
        DateVariable = "2015-09-15";
        instance.setMaturityDate(dateformatt.parse(DateVariable));
        expResult.add("Maturity Date is invalid");
        instance.setInterestFrequency(Frequency.QUATERLY);
        instance.setAmortitationFrequency(Frequency.MONTHLY);
        instance.setCurrency(Currency.BGN);

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }
}
