/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;

import java.util.*;
import ers.students.util.Currency;

/**
 *
 * @author Viktor
 */
public class AbstractPfc implements PortfolioComponent {

    private String id;
    private String parentId;
    private String name;
    private Currency currency;
    private List<String> errors =  new ArrayList<String>();



    private Map<CalculationResult, Object> calculationResults = new HashMap<CalculationResult, Object>() ;

    public void setErrorsAtribute(String errors) {
        this.errors.add(errors);
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public Map<CalculationResult, Object> getCalculationResults() {
        return calculationResults;
    }

  public void setCalculationResults(Map<CalculationResult, Object> calculationResults, CalculationResult key) {
     this.calculationResults.put(key, calculationResults);
    }

    @Override
    public List<String> getErrors() {
        return errors;
    }

    public void addErrors(String errors) {

        this.errors.add(errors);
    }

    @Override
    public void clearAllResults() {
        calculationResults = null;
    }

}
