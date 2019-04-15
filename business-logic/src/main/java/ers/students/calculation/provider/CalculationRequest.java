/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculation.provider;

import ers.students.portfolio.component.CalculationResult;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Irina
 */
public class CalculationRequest {

    private String portfolioId;
    private final List<CalculationResult> calcResults = new ArrayList<>();
    private Calendar evalDate;

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public List<CalculationResult> getCalcResults() {
        return calcResults;
    }

    public void addCalcResult(CalculationResult calcResult) {
        this.calcResults.add(calcResult);
    }

    public Calendar getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(Calendar evalDate) {
        this.evalDate = evalDate;
    }

}
