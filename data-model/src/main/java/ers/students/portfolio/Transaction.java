/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.validate.Validatable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * the class with the information of the positionId ,the payer and receiver with
 * the date of it.
 *
 * @author Viktor
 */
public class Transaction implements Validatable {

    private String id;
    private String positionId;
    private String payer;
    private String receiver;
    private Date date;
    private double amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getReciver() {
        return receiver;
    }

    public void setReciver(String receiver) {
        this.receiver = receiver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public List<String> validate() {

        List<String> validationList = new ArrayList<>();
        //ID 
        if (id == null || "".equals(id)) {

            validationList.add("id is invalid");
        }

        //positionId
        if (positionId == null | "".equals(positionId)) {

            validationList.add("positionId is invalid");
        }
        //payer

        if (payer.equals(receiver)) {
            validationList.add("payer and receiver should not be the same");

        } else if (payer == null || "".equals(payer)) {

            validationList.add("payer is invalid");

        }

        if (receiver == null || "".equals(receiver)) {

            validationList.add("receiver is invalid");
        }

        if (date == null) {

            validationList.add("date is null");
        }
        if (amount < 0) {

            validationList.add("amount is invalid");
        }
        return validationList;
    }

}
