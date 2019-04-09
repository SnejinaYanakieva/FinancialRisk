/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculation.provider;

import ers.students.calculation.resolver.CalculationResolver;
import ers.students.calculator.Calculator;
import ers.students.crud.provider.AbstractCrudProvider;
import ers.students.crud.provider.searching.PortfolioCrudProvider;
import ers.students.crud.results.LoadResult;
import ers.students.market.Market;
import ers.students.persistentStore.JdbcPersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.component.CalculationResult;
import ers.students.portfolio.component.PortfolioComponent;
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
        
        PortfolioCrudProvider portfolioCrudProvider = new PortfolioCrudProvider(new JdbcPersistentStore("", "", ""));
        LoadResult<Portfolio> portfolio = portfolioCrudProvider.loadById(calcRequest.getPortfolioId());
        
        if(!portfolio.getErrors().isEmpty()){
            return new PfcCalculationResult(PortfolioComponentType.Portfolio);
        }
        
        calculators.forEach((calculator)->{
         //  calculator.calculate(portfolio, new Market(), calcRequest.getEvalDate());
        });

        return new PfcCalculationResult(PortfolioComponentType.Portfolio);
    }

}
