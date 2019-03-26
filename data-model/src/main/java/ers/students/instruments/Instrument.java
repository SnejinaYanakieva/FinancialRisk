/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.instruments;

import ers.students.util.Currency;
import ers.students.validate.Validatable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Instrument is asset that can be traded.
 *
 * @author Viktor
 */
public class Instrument implements Validatable {

    private String id;
    private String isin;
    private Currency currency;
    private Date issueDate;
    private Date maturityDate;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
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
        //ISIN
        if (isin == null) {

            validationList.add("isin is null");
        } else if ("".equals(isin)) {

            validationList.add("isin is empty");
        }

        //Currency         
        if (currency == null) {

            validationList.add("currency is null");
        }

        //issueDate ++
        if (issueDate == null) {

            validationList.add("issueDate is null");
        }
        //maturityDate ++
        if (maturityDate == null) {

            validationList.add("maturityDate is null");
        }

        return validationList;
    }
}
