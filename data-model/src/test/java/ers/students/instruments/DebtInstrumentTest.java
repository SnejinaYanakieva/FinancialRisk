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
import org.junit.Test;

/**
 *
 * @author Viktor
 */
public class DebtInstrumentTest extends TestCase {

    @Test
    public void testValidateNull() {

        DebtInstrument instance = new DebtInstrument();
        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();

        Collections.sort(result);

        assertTrue(expResult != result);

    }

    @Test
    public void testValidateInterestRate() {

        DebtInstrument instance = new DebtInstrument();
        instance.setInterestRate(-200);
        DebtInstrument instance2 = new DebtInstrument();
        instance2.setInterestRate(8);

        List<String> result2 = instance2.validate();
        List<String> result = instance.validate();

        assertTrue(result2.size()<result.size());

    }
}
