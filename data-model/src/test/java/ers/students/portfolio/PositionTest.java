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

    public PositionTest() {
    }

    @Test
    public void testValidateTrue() throws ParseException {

        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        String issueDate = "2018-09-01";
        String maturityDate = "2018-09-02";

        Instrument Test1 = new Instrument("Tester", "What is in ?", Currency.USD, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));
        Position instance = new Position("TesterId0", "Tester", "Viktor", "Ivan", "PortFolioId:66312", Test1);

        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testValidateFalse() throws ParseException {

        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        String issueDate = "2019-09-01";
        String maturityDate = "2018-02-02";

        Instrument Test1 = new Instrument("Tester", "", Currency.USD, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));
        Position instance = new Position("", "Tester", "Viktor", "Ivan", "PortFolioId:66312", Test1);

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

        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        String issueDate = "2018-09-00";
        String maturityDate = "2018-09-00";

        Instrument Test1 = new Instrument("Tester", "What is in ?", Currency.USD, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));
        Instrument Test2 = new Instrument("Tester", "What is in ?", Currency.USD, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));

        Position obj = new Position("TesterId0", "Tester", "Viktor", "Irina", "PortFolioId:63242", Test1);
        Position instance = new Position("TesterId0", "Tester", "Viktor", "Irina", "PortFolioId:63242", Test2);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);

    }

    @Test
    public void testEqualFalseByInstrument() throws ParseException {

        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        String issueDate = "2018-09-00";
        String maturityDate = "2018-09-00";

        Instrument Test1 = new Instrument("Tester", "What is in ?", Currency.BGN, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));
        Instrument Test2 = new Instrument("Tester", "What is in ?", Currency.USD, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));

        Position obj = new Position("TesterId0", "Tester", "Viktor", "Irina", "PortFolioId:63242", Test1);
        Position instance = new Position("TesterId0", "Tester", "Viktor", "Irina", "PortFolioId:63242", Test2);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);

    }

    @Test
    public void testEqualFalse() throws ParseException {

        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        String issueDate = "2018-09-00";
        String maturityDate = "2018-09-00";

        Instrument Test1 = new Instrument("Tester", "What is in ?", Currency.BGN, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));
        Instrument Test2 = new Instrument("Tester", "What is in ?", Currency.BGN, dateformatt.parse(issueDate), dateformatt.parse(maturityDate));

        Position obj = new Position("TesterId0", "Tester", "Viktor", "Martin", "PortFolioId:63242", Test1);
        Position instance = new Position("TesterId0", "Tester", "Viktor", "Irina", "PortFolioId:63242", Test2);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);

    }

}
