/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;
  import ers.students.utill.Currency;
 
/**
 *
 * @author Viktor
 */
public class Portdolio {
    
    private String id;
    private String name;   
    Currency currency ;
 


public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
} 
public Currency getCurrency() {
    return currency;
}
public void setCurrency(Currency currency) {
    this.currency = currency;
}



}
