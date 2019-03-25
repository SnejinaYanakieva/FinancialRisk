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
        this.amortizationFrequency = amortizationFrequency;
    }

    public List<String> validate() {
        List<String> validationList = new ArrayList<>();

        //type
        if (amortizationFrequency.getType() != Calendar.MONTH && amortizationFrequency.getType() != Calendar.YEAR) {
            validationList.add("type is invalid");

        } else {
            validationList.add("type is valid");
        }
        //period

        //For month
        if (amortizationFrequency.getType() == Calendar.MONTH && amortizationFrequency.getPeriod() >= 1 && amortizationFrequency.getPeriod() != 5 && amortizationFrequency.getPeriod() <= 6) {
            validationList.add("period is valid");

        } else {
            validationList.add("period for MONTH is out of bounds");
        }

        //for year
        if (amortizationFrequency.getType() == Calendar.YEAR && (amortizationFrequency.getPeriod() == 1 || amortizationFrequency.getPeriod() == 2)) {
            validationList.add("period is valid");

        } else {
            validationList.add("period for YEAR is out of bounds");
        }

        return validationList;
    }

}
