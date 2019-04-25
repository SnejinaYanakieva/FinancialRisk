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
import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Portfolio;
import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import ers.students.portfolio.component.AbstractPfc;
import ers.students.portfolio.component.PortfolioPfc;
import ers.students.portfolio.component.PositionPfc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Irina
 */
public class CalculationProvider {

    private Map<Position, List<Transaction>> positionTransactions = new HashMap<Position, List<Transaction>>();
    private final PersistentStore persistentStore;

    public CalculationProvider(PersistentStore persistentStore) {
        this.persistentStore = persistentStore;
    }

    public PfcCalculationResult calculate(CalculationRequest calcRequest) {
        PfcCalculationResult pfcCalculationResult = new PfcCalculationResult();
        //positionTransactions = new PortfolioTransactionLoader(persistenseStore);

        // creating market
        Market market = null;

        // loading portfolio
        AbstractCrudProvider portfolioCrudProvider = new PortfolioCrudProvider(persistentStore);
        LoadResult<Portfolio> portfolioResult = portfolioCrudProvider.loadById(calcRequest.getPortfolioId());

        // checking for errors
        if (!portfolioResult.getErrors().isEmpty()) {
            portfolioResult.getErrors().forEach((errorCode, errors) -> {
                errors.forEach((error) -> {
                    pfcCalculationResult.addError(error);
                });
            });
            return pfcCalculationResult;
        }

        //transaction loader
        Portfolio portfolio = portfolioResult.getEntity();
        PortfolioPfc portfolioComponent = new PortfolioPfc(
                portfolio,
                portfolio.getId(),
                null,
                portfolio.getName(),
                portfolio.getCurrency()
        );

        positionTransactions.forEach((position, transactionsList) -> {
            PositionPfc positionPfc = new PositionPfc(
                    position,
                    transactionsList,
                    position.getId(),
                    portfolio.getId(),
                    position.getName(),
                    position.getInstrument().getCurrency()
            );
            portfolioComponent.addElement(positionPfc);
        });

        calcRequest.getCalcResults().forEach((calcResult) -> {
            Calculator calculator = CalculationResolver.getCalculator(calcResult.getName());
            calculator.calculate(portfolioComponent, market, calcRequest.getEvalDate().getTime());
        });

        return buildResult(portfolioComponent);
    }

    public void setPositionTransactions(Map<Position, List<Transaction>> positionTransactions) {
        this.positionTransactions = positionTransactions;
    }

    private PfcCalculationResult buildResult(AbstractPfc pfc) {
        PfcCalculationResult calculationResult = new PfcCalculationResult();
        calculationResult.setPfcId(pfc.getId());
        calculationResult.setPfcName(pfc.getName());

        pfc.getCalculationResults().forEach((key, value) -> {
            calculationResult.addResult(key, value);
        });

        pfc.getErrors().forEach((error) -> {
            calculationResult.addError(error);
        });

        calculationResult.setPortfolioComponentType(
                PortfolioComponentType.portfolioComponentTypes.get(pfc.getClass()));

        if (pfc instanceof PortfolioPfc) {
            ((PortfolioPfc) pfc).getElements().forEach(child
                    -> calculationResult.addChild(buildResult((AbstractPfc) child))
            );
        }

        return calculationResult;
    }

}
