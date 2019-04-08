/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Viktor
 */
public class TransactionTest {

    @Test
    public void testForNull() {

        Transaction instance = new Transaction();
        List<String> expResult = new ArrayList<>();
        expResult.add("id is invalid");
        expResult.add("positionId is invalid");
        expResult.add("payer is invalid");
        expResult.add("receiver is invalid");
        expResult.add("date is null");

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testForSame() {

        Transaction instance = new Transaction("id4433", "id12343", "Ood", "Ood", null, 42342);
        List<String> expResult = new ArrayList<>();

        expResult.add("date is null");
        expResult.add("payer and receiver should not be the same");

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testForAmaunt() {

        Transaction instance = new Transaction("id4433", "id12343", "New.Ood", "Ood", null, -42342);
        List<String> expResult = new ArrayList<>();

        expResult.add("date is null");

        expResult.add("amount is invalid");
        List<String> result = instance.validate();

        //Sorting 
        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

}
