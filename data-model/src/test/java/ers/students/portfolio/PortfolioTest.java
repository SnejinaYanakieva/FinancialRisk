/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.util.Currency;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tester
 */
public class PortfolioTest {

    public PortfolioTest() {
    }

    // @Test
    public void testValidate() {
        System.out.println("validate");
        Portfolio instance = new Portfolio();
        List<String> expResult = null;
        List<String> result = instance.validate();
        assertEquals(expResult, result);

    }

    @Test
    public void testEqualTrue() {
      
        Portfolio obj = new Portfolio("3143EVR", "Testing", Currency.BGN);
        Portfolio instance = new Portfolio("3143EVR", "Testing", Currency.BGN);
        boolean expResult = true;
        boolean result = instance.Equal(obj);

      System.out.println("expResult:" + expResult);
      System.out.println("Result:"+result);

        assertEquals(expResult, result);

    }
    @Test
    public void testEqualFalse() {
       
        Portfolio obj = new Portfolio("3143EVR", "Testing", Currency.BGN);
        Portfolio instance = new Portfolio("256EVR", "Testing", Currency.BGN);
        boolean expResult = false;
        boolean result = instance.Equal(obj);

        System.out.println("expResult:" + expResult);
        System.out.println("Result:"+result);

        assertEquals(expResult, result);

    }
}
