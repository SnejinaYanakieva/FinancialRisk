/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viktor
 */
public class FxQuoteTest {

    public FxQuoteTest() {

    }

    /**
     * Test of validate method, of class FxQuote.
     */
    public void basicInfo(List<String> expResult) {

        expResult.add("From variable is not valid");
        expResult.add("id is not valid");
        expResult.add("Date is null");
        expResult.add("To variable is null");
        Collections.sort(expResult);
    }

    @Test
    public void testValidateForNull() {

        FxQuote instance = new FxQuote();
        instance.setValue(22);
        List<String> expResult = new ArrayList<>();

        basicInfo(expResult);
        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testValidateForValue() {

        FxQuote instance = new FxQuote();
        instance.setValue(122);
        List<String> expResult = new ArrayList<>();

        expResult.add("Value is out of bound");
        basicInfo(expResult);

        List<String> result = instance.validate();

        Collections.sort(result);

        assertEquals(expResult, result);

    }
}
