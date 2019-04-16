/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

import ers.students.crud.provider.FxCrudProvider;
import ers.students.crud.provider.YieldCurveCrudProvider;
import ers.students.crud.results.LoadResult;
import ers.students.persistentStore.PersistentStore;

/**
 *
 * @author Viktor
 */
public class DataMarketLoader implements Market {

    PersistentStore persistentStore;
    String dbURL;

    public DataMarketLoader(PersistentStore persistentStore, String dbURL) {
        this.persistentStore = persistentStore;
        this.dbURL = dbURL;
    }

    @Override
    public YieldCurve getYieldCurve() {

        YieldCurveCrudProvider yeldCurveProvider = new YieldCurveCrudProvider(persistentStore);
        LoadResult<YieldCurve> curve = yeldCurveProvider.loadById(dbURL);

        return curve.getEntity();
    }

    @Override
    public FxQuote getFxQuote() {

        FxCrudProvider fxCurveProvider = new FxCrudProvider(persistentStore);
        LoadResult<FxQuote> fxQuote = fxCurveProvider.loadById(dbURL);

        return fxQuote.getEntity();
    }

}
