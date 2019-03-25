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

    public List<String> validate() {

        List<String> validationList = new ArrayList<>();
        //ID 
        try {

            Integer.parseInt(id);
            validationList.add("id is valid");

        } catch (NumberFormatException e) {
            validationList.add("id is invalid");
        } catch (NullPointerException e) {
            validationList.add("id is null");
        }

        //portfolioId
        try {

            Integer.parseInt(positionId);
            validationList.add("positionId is valid");

        } catch (NumberFormatException e) {
            validationList.add("positionId is invalid");
        } catch (NullPointerException e) {
            validationList.add("positionId is null");
        }
        //payer

        if (payer == receiver) {
            validationList.add("payer = receiver");

        } else if (payer == null) {

            validationList.add("payer is null");
        } else {
            validationList.add("payer is valid");
        }

        //receiver
        if (receiver == payer) {
            validationList.add("receiver = payer");

        } else if (receiver == null) {

            validationList.add("receiver is null");
        } else {
            validationList.add("receiver is valid");
        }
        //date
        if (date == null) {

            validationList.add("date is null");
        }
        return validationList;
    }

}
