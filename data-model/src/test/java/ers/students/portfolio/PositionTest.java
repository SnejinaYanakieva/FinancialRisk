/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.instruments.Instrument;
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
public class PositionTest {

    public PositionTest() {
    }

 //   @Test
    public void testValidate() {
        System.out.println("validate");
        Position instance = new Position();
        List<String> expResult = null;
        List<String> result = instance.validate();
        assertEquals(expResult, result);
      
    }

}
