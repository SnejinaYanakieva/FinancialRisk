/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.validate.Validatable;
import java.util.Date;
import java.util.List;

/**
 *the class with the information of the positionId ,the payer and receiver with the date of it. 
 * @author Viktor
 */
public class Transaction implements Validatable{

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

        throw new UnsupportedOperationException("Unsupported operation.");
    }

}
