/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;
import java.util.Date;
/**
 *
 * @author Viktor
 */
public class Transaction {
    private String id;
    private String positionId;
    private String payer;
     private String reciver;
    private Date date ;   


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
        return reciver;
}
public void setReciver(String reciver) {
        this.reciver = reciver;
}
public Date getDate() {
        return date;
}
public void setDate(Date date) {
        this.date = date;
}

}
