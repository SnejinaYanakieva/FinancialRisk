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
        if (id == null) {

            validationList.add("id is null");
        } else if ("".equals(id)) {

            validationList.add("id is empty");
        }

        //positionId
        if (positionId == null) {

            validationList.add("positionId is null");
        } else if ("".equals(positionId)) {

            validationList.add("positionId is empty");
        }
        //payer

        if (payer.equals(receiver)) {
            validationList.add("payer = longSide");

        } else if (payer == null) {

            validationList.add("payer is null");

        } else if ("".equals(payer)) {
            validationList.add("payer is empty");
        }

        //receiver
        if (receiver == null) {

            validationList.add("receiver is null");
        } else {
            validationList.add("receiver is valid");
        }

        //date
        if (date == null) {

            validationList.add("date is null");
        }
        if (amount < 0) {

            validationList.add("amount is invalid");
        }
        return validationList;
    }

}
