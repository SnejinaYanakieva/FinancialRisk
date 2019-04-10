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

    public SimpleDateFormat getFormat() {
        SimpleDateFormat dateformatt = new SimpleDateFormat("yyyyy-mm-dd");
        return dateformatt;
    }

    public Instrument createInstrument() throws ParseException {

        String issueDate = "2018-09-01";
        String maturityDate = "2018-09-02";

        Instrument instrumentOne = new Instrument("Tester", "CodeTest64363", Currency.USD, getFormat().parse(issueDate), getFormat().parse(maturityDate));
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
    public void testValidateFalse() throws ParseException {

        String maturityDate = "2018-02-02";

        Instrument instrumentOne = createInstrument();
        instrumentOne.setMaturityDate(getFormat().parse(maturityDate));
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
    public void testEqualTrue() throws ParseException {

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
