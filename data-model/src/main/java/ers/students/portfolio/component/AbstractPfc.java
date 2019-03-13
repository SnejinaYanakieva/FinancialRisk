/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;

import java.util.*;
import ers.students.util.Currency;

/**
 * used as a basis for creating the Pfc
 * @author Viktor
 */
public class AbstractPfc implements PortfolioComponent {

    private String id;
    private String parentId;
    private String name;
    private Currency currency;
    private final List<String> errors = new ArrayList<String>();

    private final Map<CalculationResult, Object> calculationResults = new HashMap<CalculationResult, Object>();

    /**
     *
     * @return
     */
    @Override
    public Map<CalculationResult, Object> getCalculationResults() {
        return calculationResults;
    }

    /**
     *
     * @param calculationResult
     * @param value
     * @param key
     */
    public void addCalculationResult(CalculationResult key, Object value) {
        this.calculationResults.put(key,value);
    }

    /**
     *
     * @return
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String getParentId() {
        return parentId;
    }

    /**
     *
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Override
    public Currency getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     *
     * @return
     */
    @Override
    public List<String> getErrors() {
        return errors;
    }

    /**
     *
     * @param errors
     */
    public void addError(String error) {

        this.errors.add(error);
    }

    /**
     * @Clearing the calculationResults
     */
    @Override
    public void clearAllResults() {
        calculationResults.clear();
    }

}
