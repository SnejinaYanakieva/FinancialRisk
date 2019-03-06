/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

import ers.students.util.Currency;
import java.util.*;

/**
 *
 * @author Viktor
 */
public class FxQuote {

    private String id;
    private Currency from;
    private Currency to;
    private Date date;
    private double value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Currency getFrom() {
        return from;
    }

    public void setFrom(Currency from) {
        this.from = from;
    }

    public Currency getTo() {
        return to;
    }

    public void setTo(Currency to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
