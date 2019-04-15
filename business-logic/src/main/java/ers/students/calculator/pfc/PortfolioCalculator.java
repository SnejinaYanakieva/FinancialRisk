/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.calculator.pfc;

import ers.students.crud.provider.AbstractCrudProvider;
import ers.students.crud.provider.searching.PositionCrudProvider;
import ers.students.crud.results.LoadResults;
import java.util.Date;

import ers.students.market.Market;
import ers.students.persistentStore.JdbcPersistentStore;
import ers.students.portfolio.Position;
import ers.students.portfolio.component.DoubleResult;
import ers.students.portfolio.component.PortfolioComponent;

/**
 * The PortfolioCalculator class provides methods for calculating cash flow,
 * present value, profit and loss, position volume.
 *
 * @author Irina
 */
public class PortfolioCalculator implements PortfolioComponentCalculator {

    /**
     * Calculates the sum of all Present Values.
     *
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculatePresentValue(PortfolioComponent pfc, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Calculates the sum of all Profit/Loss values.
     *
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculateProfitLoss(PortfolioComponent pfc, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    /**
     * Calculates the amount of transactions.
     *
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculatePositionVolume(PortfolioComponent pfc, Market market, Date evalDate) {
        AbstractCrudProvider crudProvider = new PositionCrudProvider(new JdbcPersistentStore("", "", ""));
        LoadResults<Position> positionResults = crudProvider.loadAll();

        if (!positionResults.getErrors().isEmpty()) {
            return;
        }

        // get volume
        positionResults.getEntities().forEach((position) -> {
            if (position.getPortfolioId().equals(pfc.getId())) {
                pfc.getCalculationResults().put(DoubleResult.POSITION_VOLUME, "");
            }
        });
    }

    /**
     * Calculates the interest and principal payments.
     *
     * @param pfc component on which will be executed calculation
     * @param market
     * @param evalDate date of calculation
     */
    @Override
    public void calculateCashFlow(PortfolioComponent pfc, Market market, Date evalDate) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }
}
