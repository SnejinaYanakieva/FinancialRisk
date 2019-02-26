/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;
import java.util.*;
import ers.students.utill.Currency;
import ers.students.portfolio.component.CalculationResult;
import ers.students.portfolio.component.PortfolioComponent;

/**
 *
 * @author Viktor
 */  




public class AbstractPfc implements PortfolioComponent {
  private String id;
  private String parentId;
  private String name;
  private Currency currency ;  
  private List<String> errors;


  
  private Map<CalculationResult, Object> calculationResults;
  
  
      public List<String> getList() {
        return errors;
    }

    public void setErrorsAtribute(String errors) {
        this.errors.add(errors);
    }
  
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

    public List<String> getErrors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clearAllResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}