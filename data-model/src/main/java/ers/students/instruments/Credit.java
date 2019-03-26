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
import java.util.Calendar;

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
        //this.amortizationFrequency= Frequency.MONTHLY;
        this.amortizationFrequency = amortizationFrequency;
    }

    @Override
    public List<String> validate() {
        List<String> validationList = new ArrayList<>();

        if (amortizationFrequency == null) {
            validationList.add("interestRate is null");
        }
        validationList.addAll(super.validate());
        return validationList;
    }

}
