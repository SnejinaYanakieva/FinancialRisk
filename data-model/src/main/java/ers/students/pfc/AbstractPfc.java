/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.pfc;
import java.util.*;
import ers.students.utill.Currency;
import ers.students.portfolio.component.CalculationResult;

/**
 *
 * @author Viktor
 */  
import ers.students.utill.Currency;



public class AbstractPfc {
  private String id;
  private String parentId;
  private String name;
  Currency currency ;  
  
  private Map<CalculationResult, Object> calculationResults;
  
  
  public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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

	public Map<CalculationResult, Object> getCalculationResults() {
		return calculationResults;
	}

	public void setCalculationResults(Map<CalculationResult, Object> calculationResults) {
		this.calculationResults = calculationResults;
	}

}
