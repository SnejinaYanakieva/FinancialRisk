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

    public FxQuote() {
    }

    public FxQuote(String id, Currency from, Currency to, Date date, double value) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.value = value;
    }

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

    @Override
    public List<String> validate() {

        List<String> validationList = new ArrayList<>();

        if (id == null || "".equals(id)) {

            validationList.add("id is not valid");
        }

        if (from == null || from.equals(to)) {

            validationList.add("from is not valid");

        }
        if (to == null) {

            validationList.add("to is null");
        }

        if (date == null) {

            validationList.add("date is null");
        }
        // value
        if (value < 0 && value > 100) {

            validationList.add("date is out of bound");
        }
        return validationList;
    }
}
