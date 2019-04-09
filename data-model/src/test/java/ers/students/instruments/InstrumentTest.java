/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.util.Currency;
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
public class InstrumentTest extends TestCase {

    @Test
    public void testForNull() {

        Instrument instance = new Instrument();
        List<String> expResult = new ArrayList<>();
        expResult.add("Id is invalid");
        expResult.add("Isin is invalid");
        expResult.add("Currency is null");
        expResult.add("Issue Date is null");
        expResult.add("Maturity Date is invalid");
        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testForDate() throws ParseException {

        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        String issueDate = "2018-04-02";
        String maturityDate = "2017-09-02";

        Instrument instance = new Instrument("Tester", "What is in ?", Currency.USD, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));

        List<String> expResult = new ArrayList<>();

        expResult.add("Maturity Date is invalid");
        List<String> result = instance.validate();

        //Sorting 
        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }
}
