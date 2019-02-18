/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;
  import ers.students.utill.Currency;
import java.util.Date;
/**
 *
 * @author tester
 */
public class Instrument {
    private String id;
    private String isin;
    Currency currency =  Currency.BGN;
    private Date issueDate = new Date();
    private Date maturityDate = new Date();
    
}
