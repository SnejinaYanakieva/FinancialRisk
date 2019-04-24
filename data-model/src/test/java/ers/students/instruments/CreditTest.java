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
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Viktor
 */
public class CreditTest extends TestCase {

    public List<String> initValidate(Credit instance) {

        instance.setId("Test123");
        instance.setIsin("Test");
        instance.setInterestFrequency(Frequency.QUATERLY);
        instance.setAmortitationFrequency(Frequency.MONTHLY);
        instance.setCurrency(Currency.BGN);

        List<String> result = instance.validate();

        Collections.sort(result);

        return result;
    }

    @Test
    public void testForNull() {

        Credit instance = new Credit();
        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertFalse(expResult == result);

    }

    @Test
    public void testValidateInterestRate() {

        List<String> expResult = new ArrayList<>();
        Credit instance = new Credit();
        Credit instance2 = new Credit();
        instance.setInterestRate(222);
        instance.setInterestRate(7);

        Date date = new Date(2018, 9, 1);
        instance.setIssueDate(date);
        instance2.setIssueDate(date);
        Date date2 = new Date(2019, 9, 1);
        instance.setMaturityDate(date2);
        instance2.setMaturityDate(date2);
        List<String> result2 = initValidate(instance2);
        List<String> result = initValidate(instance);

        Collections.sort(expResult);

        assertEquals(expResult, result);

    }

    @Test
    public void testValidateDate() throws ParseException {
        List<String> expResult = new ArrayList<>();
        Credit instance = new Credit();

        instance.setInterestRate(3);
        Date date = new Date(2018, 9, 1);
        instance.setIssueDate(date);
        Date date2 = new Date(2015, 9, 1);
        instance.setMaturityDate(date2);

        List<String> result = initValidate(instance);

        Collections.sort(expResult);

        assertTrue(expResult != result);

    }
}
