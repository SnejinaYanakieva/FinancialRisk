/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

import ers.students.util.Currency;
import ers.students.validate.Validatable;
import java.util.*;

/**
 * ' Its the Currency to Currency rate of exchange for a certain date.
 *
 * @author Viktor
 */
public class FxQuote implements Validatable {

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

    public List<String> validate() {

        List<String> validationList = new ArrayList<>();
        //id
        if (id == null) {

            validationList.add("id is null");
        } else if ("".equals(id)) {

            validationList.add("id is empty");
        }
//curr
        if (from == null) {

            validationList.add("from is null");
        }
        if (from.equals(to)) {
            validationList.add("from is equals to");

        }
        if (to == null) {

            validationList.add("to is null");
        }
//date
        if (date == null) {

            validationList.add("date is null");
        }
        // value
        if (value > 0 && value < 100) {

            validationList.add("date is out of bound");
        }
        return validationList;
    }
}
