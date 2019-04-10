/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.util.Currency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 *  * @author Viktor
 */
public class PortfolioTest {

    @Test
    public void testValidateTrue() {

        Portfolio instance = new Portfolio("3143EVR", "Testing", Currency.BGN);
        List<String> result = instance.validate();
        assert (result.isEmpty());
    }

    @Test
    public void testValidateFalse() {

        Portfolio instance = new Portfolio("", "", null);
        List<String> expResult = new ArrayList<>();
        List<String> result = instance.validate();

        expResult.add("id is invalid");
        expResult.add("name is invalid");
        expResult.add("currency is null");

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);
    }

    @Test
    public void testEqualTrue() {

        Portfolio obj = new Portfolio("3143EVR", "Testing", Currency.BGN);
        Portfolio instance = new Portfolio("3143EVR", "Testing", Currency.BGN);
        assert (instance.equals(obj));
    }

    @Test
    public void testEqualFalse() {
        Portfolio obj = new Portfolio("3143EVR", "Testing", Currency.BGN);
        Portfolio instance = new Portfolio("256EVR", "Testing21", Currency.USD);
        assertFalse(instance.equals(obj));
    }
}
