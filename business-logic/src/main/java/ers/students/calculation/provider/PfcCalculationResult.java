/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculation.provider;

import ers.students.portfolio.component.CalculationResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Irina
 */
public class PfcCalculationResult {

    private String pfcId;
    private String pfcName;
    private Map<CalculationResult, Object> results = new HashMap<>();
    private List<PfcCalculationResult> children = new ArrayList<>();
    private List<String> errors = new ArrayList<>();
    private final PortfolioComponentType portfolioComponentType;

    public PfcCalculationResult(PortfolioComponentType portfolioComponentType) {
        this.portfolioComponentType = portfolioComponentType;
    }

    public String getPfcId() {
        return pfcId;
    }

    public void setPfcId(String pfcId) {
        this.pfcId = pfcId;
    }

    public String getPfcName() {
        return pfcName;
    }

    public void setPfcName(String pfcName) {
        this.pfcName = pfcName;
    }

    public Map<CalculationResult, Object> getResults() {
        return results;
    }

    public void addResult(CalculationResult key, Object value) {
        this.results.put(key, value);
    }

    public List<PfcCalculationResult> getChildren() {
        return children;
    }

    public void addChild(PfcCalculationResult child) {
        this.children.add(child);
    }

    public List<String> getErrors() {
        return errors;
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public PortfolioComponentType getPortfolioComponentType() {
        return portfolioComponentType;
    }

}
