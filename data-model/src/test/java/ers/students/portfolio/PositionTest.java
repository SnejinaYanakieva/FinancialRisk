/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.instruments.Instrument;
import ers.students.util.Currency;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viktor
 */
public class PositionTest {

    SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");

    public Instrument createInstrument() throws ParseException {

        String issueDate = "2018-09-01";
        String maturityDate = "2018-09-02";

        Instrument test1 = new Instrument("Tester", "CodeTest64363", Currency.USD, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));
        return test1;
    }

    public Position createPosition(Instrument test1) {
        Position obj = new Position("TesterId0", "Tester", "Viktor", "Irina", "PortFolioId:63242", test1);

        return obj;
    }

   /* @Test
    public void testValidateTrue() {

       // Position instance = new Position("TesterId0", "Tester", "Viktor", "Ivan", "PortFolioId:66312", createInstrument());

        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }*/

    @Test
    public void testValidateFalse() throws ParseException {

        String maturityDate = "2018-02-02";

        Instrument test1 = createInstrument();
        test1.setMaturityDate(dateformatt.parse(maturityDate));
        Position instance = createPosition(test1);

        List<String> expResult = new ArrayList<>();
        List<String> result = instance.validate();

        expResult.add("id is invalid");
        expResult.add("Isin is invalid");
        expResult.add("Maturity Date is invalid");
        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testEqualTrue() throws ParseException {

        Instrument test1 = createInstrument();
        Instrument test2 = createInstrument();

        Position obj = createPosition(test1);
        Position instance = createPosition(test2);

        assert (instance.equals(obj));

    }

    @Test
    public void testEqualFalseByInstrument() throws ParseException {

        Instrument test1 = createInstrument();
        Instrument test2 = createInstrument();
        test2.setCurrency(Currency.USD);

        Position obj = createPosition(test1);
        Position instance = createPosition(test2);

        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);

    }

    @Test
    public void testEqualFalse() throws ParseException {

        Instrument test1 = createInstrument();
        Instrument test2 = createInstrument();
        test2.setCurrency(Currency.USD);

        Position obj = createPosition(test1);
        Position instance = createPosition(test2);
        instance.setId("ID_For_Test");

        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);

    }

}
