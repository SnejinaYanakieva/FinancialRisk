/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import java.util.Date;
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
public class TransactionTest {

    public TransactionTest() {
    }

    //@Test
    public void testValidate() {
        System.out.println("validate");
        Transaction instance = new Transaction();
        List<String> expResult = null;
        List<String> result = instance.validate();
        assertEquals(expResult, result);
      
    }

}
