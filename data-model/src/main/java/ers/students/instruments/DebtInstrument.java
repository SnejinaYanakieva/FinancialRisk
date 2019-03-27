/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.util.Frequency;
import java.util.ArrayList;
import java.util.List;

/**
 * Debt instrument is when someone is getting into a debt
 *
 * @author Viktor
 */
public class DebtInstrument extends Instrument {

    private double interestRate;
    private Frequency interestFrequency;

    public DebtInstrument() {
    }

    public DebtInstrument(double interestRate, Frequency interestFrequency) {
        this.interestRate = interestRate;
        this.interestFrequency = interestFrequency;
    }

    
    public Frequency getInterestFrequency() {
        return interestFrequency;
    }

    public void setInterestFrequency(Frequency interestFrequency) {
        this.interestFrequency = interestFrequency;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public List<String> validate() {

        List<String> validationList = new ArrayList<>();
        validationList.addAll(super.validate());
        if (interestRate < 0 && interestRate > 100) {
            validationList.add("interestRate is out of bound");
        }
        if (interestFrequency == null) {
            validationList.add("interestFrequency is null");
        }

        return validationList;
    }

}
