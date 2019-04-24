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
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viktor
 */
public class PositionTest {

    public Instrument createInstrument() throws ParseException {

        Date date = new Date(2018, 4, 1);

        Date date2 = new Date(2019, 5, 1);

        Instrument instrumentOne = new Instrument("Tester", "CodeTest64363", Currency.USD, date, date2);
        return instrumentOne;
    }

    public Position createPosition(Instrument instrumentOne) {
        Position obj = new Position("TesterId0", "Tester", "Viktor", "Irina", "PortFolioId:63242", instrumentOne);

        return obj;
    }

    @Test
    public void testValidateTrue() throws ParseException {

        Position instance = createPosition(createInstrument());

        List<String> expResult = new ArrayList<>();

        List<String> result = instance.validate();

        Collections.sort(expResult);
        Collections.sort(result);

        assertEquals(expResult, result);

    }

    @Test
    public void testValidateFalse() throws ParseException  {

        Date date = new Date(2018, 5, 1);
        Instrument instrumentOne = createInstrument();
        instrumentOne.setMaturityDate(date);
        Position instance = createPosition(instrumentOne);

        List<String> expResult = new ArrayList<>();
        List<String> result = instance.validate();

        expResult.add("id is invalid");
        expResult.add("Isin is invalid");
        expResult.add("Maturity Date is invalid");

        Collections.sort(expResult);
        Collections.sort(result);

        assertFalse(expResult.equals(result));

    }

    @Test
    public void testEqualTrue() throws ParseException  {

        Position obj = createPosition(createInstrument());
        Position instance = createPosition(createInstrument());

        assert (instance.equals(obj));

    }

    @Test
    public void testEqualFalseByInstrument() throws ParseException {

        Instrument instrumentTwo = createInstrument();
        instrumentTwo.setCurrency(Currency.BGN);

        Position obj = createPosition(createInstrument());
        Position instance = createPosition(instrumentTwo);

        assertFalse(instance.equals(obj));

    }

    @Test
    public void testEqualFalse() throws ParseException {

        Instrument instrumentOne = createInstrument();

        Position obj = createPosition(instrumentOne);
        Position instance = createPosition(instrumentOne);
        instance.setId("ID_For_Test");

        assertFalse(instance.equals(obj));

    }

    @Test
    public void testInstrumentValidation() throws ParseException {

        Instrument instrumentOne = createInstrument();
        instrumentOne.setIsin(null);
        Position instance = createPosition(instrumentOne);
        List<String> result = instance.validate();

        assertFalse(result.isEmpty());
    }

}
