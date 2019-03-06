/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.util.Frequency;

/**
 *
 * @author Viktor
 */
public class Credit extends DebtInstrument {

    private Frequency amortitationFrequency;

    public Frequency getAmortitationFrequency() {
        return amortitationFrequency;
    }

    public void setAmortitationFrequency(Frequency amortitationFrequency) {
        this.amortitationFrequency = amortitationFrequency;
    }

}
