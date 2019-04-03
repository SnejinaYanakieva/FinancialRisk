/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import java.util.List;
import ers.students.validate.Validatable;
import ers.students.util.Frequency;
import java.util.ArrayList;

/**
 *
 * Credit is contractual agreement in which a borrower receives something of value now 
 * and agrees to repay the lender at a later date—generally with interest..
 *
 * @author Viktor
 */
public class Credit extends DebtInstrument implements Validatable {

    private Frequency amortizationFrequency;

    public Credit() {
    }

    public Credit(Frequency amortizationFrequency) {
        this.amortizationFrequency = amortizationFrequency;
    }

    public Frequency getAmortitationFrequency() {
        return amortizationFrequency;
    }

    public void setAmortitationFrequency(Frequency amortizationFrequency) {
        //this.amortizationFrequency= Frequency.MONTHLY;
        this.amortizationFrequency = amortizationFrequency;
    }

    @Override
    public List<String> validate() {
        List<String> validationList = new ArrayList<>();
        validationList.addAll(super.validate());
        if (amortizationFrequency == null) {
            validationList.add("The amortization Frequency is null");
        }

        return validationList;
    }

}
