/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.validate.Validatable;
import java.util.List;

/**
 *Deposit is when the short side give money to the long side for safe keep while gaining interest.
 * @author Viktor
 */
public class Deposit extends DebtInstrument implements Validatable {
   public List<String> validate() {

        throw new UnsupportedOperationException("Unsupported operation.");
    }
}
