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

    private final PersistentStore persistentStore;
    private final String idFx;
    private final String idYeld;
    private final YieldCurveCrudProvider yeldCurveProvider;
    private final FxCrudProvider fxCurveProvider;

    public DataMarketLoader(PersistentStore persistentStore, String idYeld, String idFx) {
        this.persistentStore = persistentStore;
        this.idYeld = idYeld;
        this.idFx = idFx;
        yeldCurveProvider = new YieldCurveCrudProvider(persistentStore);
        fxCurveProvider = new FxCrudProvider(persistentStore);
    }

    @Override
    public YieldCurve getYieldCurve() {

        LoadResult<YieldCurve> curve = yeldCurveProvider.loadById(idYeld);

        return curve.getEntity();
    }

    @Override
    public FxQuote getFxQuote() {

        LoadResult<FxQuote> fxQuote = fxCurveProvider.loadById(idFx);

        return fxQuote.getEntity();
    }

}
