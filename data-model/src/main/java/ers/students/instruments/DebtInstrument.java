/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.validate.Validatable;
import java.util.ArrayList;
import java.util.List;

/**
 * Debt instrument is when someone is getting into a debt
 * @author Viktor
 */
public class DebtInstrument extends Instrument implements Validatable {

    private double interestRate;

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
 public List<String> validate() {
  List<String> validationList = new ArrayList<>();
        if(interestRate>0){
            validationList.add("interestRate is valid");
        }
        else{
              validationList.add("interestRate is invalid");
        }
        return validationList;
    }

    
}
