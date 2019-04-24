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
public class YieldCurveTest {

    public YieldCurveTest() {
    }

    @Test
    public void testValidateForNull() {

        YieldCurve instance = new YieldCurve();

        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();

        assertTrue(expResult != result);

    }

    @Test
    public void testValidateForYield() {

        YieldCurve instance = new YieldCurve("TesterID", "Tester", 22, 214, 21, 53, 23, 0, 43, 42, 75, -45);
        YieldCurve instance2 = new YieldCurve("TesterID", "Tester", 22, 12, 21, 53, 23, 0, 43, 42, 75, 31);

        List<String> result = instance.validate();
        List<String> result2 = instance2.validate();

        int size1 = result.size();
        int size2 = result2.size();

        assertTrue(size1 == (size2 + 2));

    }
}
