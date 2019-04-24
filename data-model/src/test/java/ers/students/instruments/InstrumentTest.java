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
import java.util.Date;
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

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertTrue(expResult != result);

    }
// В result има "MaturityDate should be later then issueDate" 

    @Test
    public void testForDate() {

        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        Date date = new Date(2018, 4, 1);
        Date date2 = new Date(2017, 4, 1);

        Instrument instance = new Instrument("Tester", "Code352523", Currency.USD, date, date2);

        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();

        //Sorting 
        Collections.sort(expResult);
        Collections.sort(result);

        assertFalse(expResult.equals(result));

    }
}
