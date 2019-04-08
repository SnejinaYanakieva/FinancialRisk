/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculation.provider;

import ers.students.calculation.resolver.CalculationResolver;
import ers.students.calculator.Calculator;
import ers.students.market.Market;
import ers.students.portfolio.component.CalculationResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Irina
 */
public abstract class AbstractCalculationProvider {

    public PfcCalculationResult calculate(CalculationRequest calcRequest) {
        //PfcCalculationResult pfcCalculationResult = new PfcCalculationResult();
        List<CalculationResult> calcResults = calcRequest.getCalcResults();
        List<Calculator> calculators = new ArrayList<>();

        calcResults.forEach((calcResult) -> {
            calculators.add(new CalculationResolver().getCalculator(calcResult.getName()));
        });
        
        calculators.forEach((calculator)->{
            //calculator.calculate(portfolioComponent, market, evalDate);
        });

        return new PfcCalculationResult(PortfolioComponentType.Portfolio);
    }

}
