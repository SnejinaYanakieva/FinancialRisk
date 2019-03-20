/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import java.util.List;
import ers.students.validate.Validatable;
import ers.students.util.Frequency;

/**
 *
 * Credit is when someone is given money and he have to return it with interest.
 *
 * @author Viktor
 */
public class Credit extends DebtInstrument implements Validatable {

    private Frequency amortizationFrequency;

    public Frequency getAmortitationFrequency() {
        return amortizationFrequency;
    }

    public void setAmortitationFrequency(Frequency amortizationFrequency) {
        this.amortizationFrequency = amortizationFrequency;
    }

    public List<String> validate() {

        throw new UnsupportedOperationException("Unsupported operation.");
    }

}
