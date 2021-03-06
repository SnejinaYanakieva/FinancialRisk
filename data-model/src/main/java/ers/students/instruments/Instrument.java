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

/*
 * An instrument is a tradable asset or negotiable item such as
 * a security, commodity, derivative or index, or any item that underlies a derivative. 
 *
 * @author Viktor
 */
public class Instrument implements Validatable {

    private String id;
    private String isin;
    private Currency currency;
    private Date issueDate;
    private Date maturityDate;

    public Instrument() {
    }

    public Instrument(String id, String isin, Currency currency, Date issueDate, Date maturityDate) {
        this.id = id;
        this.isin = isin;
        this.currency = currency;
        this.issueDate = issueDate;
        this.maturityDate = maturityDate;
    }

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

    public boolean equals(Instrument obj) {

        return this.id.equals(obj.id)
                && this.isin.equals(obj.isin)
                && this.currency.equals(obj.currency)
                && this.issueDate.equals(obj.issueDate)
                && this.maturityDate.equals(obj.maturityDate);
    }

    @Override
    public List<String> validate() {
        List<String> validationList = new ArrayList<>();

        //ID 
        if (id == null || "".equals(id)) {

            validationList.add("Id is invalid");
        }
        //ISIN
        if (isin == null || "".equals(isin)) {

            validationList.add("Isin is invalid");
        }

        //Currency         
        if (currency == null) {

            validationList.add("Currency is null");
        }

        //issueDate 
        if (issueDate == null) {

            validationList.add("Issue Date is null");
        }

        //maturityDate 
        if (maturityDate == null) {

            validationList.add("Maturity Date is null");
        }
        
          if (maturityDate != null && issueDate != null) {
            if ( maturityDate.compareTo(issueDate) <0) {
                validationList.add("MaturityDate should be later then issueDate");

            } else if(maturityDate.compareTo(issueDate) == 0)
            {
                      validationList.add("MaturityDate and IssueDate should not be the same");
            
            
            }
            
        }

        return validationList;
    }


}
