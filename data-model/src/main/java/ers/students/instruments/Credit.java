/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.util.Frequency;

/**
 * 
 *Credit is when someone is given money and he have to return it with interest.
 * 
 * @author Viktor
 */
public class Credit extends DebtInstrument {

    private Frequency amortizationFrequency;

    public Frequency getAmortitationFrequency() {
        return amortizationFrequency;
    }

    public void setAmortitationFrequency(Frequency amortizationFrequency) {
        this.amortizationFrequency = amortizationFrequency;
    }

}
