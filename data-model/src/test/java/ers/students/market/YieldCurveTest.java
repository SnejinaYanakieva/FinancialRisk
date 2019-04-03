/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

import java.util.ArrayList;
import java.util.Collections;
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
public class YieldCurveTest {

    public YieldCurveTest() {
    }

    @Test
    public void testValidateForNull() {

        YieldCurve instance = new YieldCurve();

        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();
        expResult.add("id is invalid");
        expResult.add("name is invalid");
        /*
        System.out.println("Expected Result List Start Here :");

        for (int i = 0; i < expResult.size(); i++) {
            System.out.println(expResult.get(i));
        }
        System.out.println();
        System.out.println("Result List Start Here :");

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
         */
        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testValidateForYield() {

        YieldCurve instance = new YieldCurve("TesterID", "Tester", 22, 214, 21, 53, 23, 0, 43, 42, 75, -45);

        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();
        expResult.add("The Yield for 30 year is invalid");
        expResult.add("The Yield for 2 month is invalid");

        System.out.println("Expected Result List Start Here :");

        for (int i = 0; i < expResult.size(); i++) {
            System.out.println(expResult.get(i));
        }
        System.out.println();
        System.out.println("Result List Start Here :");

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }
}
