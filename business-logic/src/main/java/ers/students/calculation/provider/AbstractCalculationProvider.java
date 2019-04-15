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
import ers.students.crud.results.LoadResults;
import ers.students.persistentStore.JdbcPersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import ers.students.portfolio.component.CalculationResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Irina
 */
public abstract class AbstractCalculationProvider {

    public PfcCalculationResult calculate(CalculationRequest calcRequest) {
        PfcCalculationResult pfcCalculationResult = new PfcCalculationResult();
        List<CalculationResult> calcResults = calcRequest.getCalcResults();
        List<Calculator> calculators = new ArrayList<>();

        // getting calculators
        calcResults.forEach((calcResult) -> {
            calculators.add(new CalculationResolver().getCalculator(calcResult.getName()));
        });

        // creating market
        // loading portfolio
        AbstractCrudProvider portfolioCrudProvider = new PortfolioCrudProvider(new JdbcPersistentStore("", "", ""));
        LoadResult<Portfolio> portfolio = portfolioCrudProvider.loadById(calcRequest.getPortfolioId());

        // checking for errors
        if (!portfolio.getErrors().isEmpty()) {
            portfolio.getErrors().forEach((errorCode, errors) -> {
                errors.forEach((error) -> {
                    pfcCalculationResult.addError(error);
                });
            });
            return pfcCalculationResult;
        }

        // loading positions
        AbstractCrudProvider positionCrudProvider = new PortfolioCrudProvider(new JdbcPersistentStore("", "", ""));
        LoadResults<Position> positions = new LoadResults<>();

        List<Transaction> transactionsList = new ArrayList<Transaction>();
        //transaction loader

        return pfcCalculationResult;
    }

}
