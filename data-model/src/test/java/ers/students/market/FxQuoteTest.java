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
    @Test
    public void testValidateForNull() {

        FxQuote instance = new FxQuote();
        instance.setValue(22);
        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertTrue(expResult != result);

    }

    @Test
    public void testValidateForValue() {

        FxQuote instance = new FxQuote();
        instance.setValue(122);
        FxQuote instance2 = new FxQuote();
        instance2.setValue(2);

        List<String> result2 = instance2.validate();
        List<String> result = instance.validate();

        Collections.sort(result);

        assertTrue(!result2.equals(result));

    }
}
