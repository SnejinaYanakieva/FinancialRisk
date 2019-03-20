/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.util.Currency;
import ers.students.validate.Validatable;
import java.util.List;

/**
 *Its used for having a range of investments 
 * @author Viktor
 */
public class Portfolio implements Validatable{

    private String id;
    private String name;
    private Currency currency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
 public List<String> validate() {

        throw new UnsupportedOperationException("Unsupported operation.");
    }
}
