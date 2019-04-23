/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

import ers.students.persistentStore.PersistentStore;

/**
 *
 * @author Viktor
 */
public class CachingMarket implements Market {
//temp

    private final DataMarketLoader dataMarketLoader;
 private YieldCurve cacheYieldCurve;
    private FxQuote cacheFxQuote;
//
    public CachingMarket(PersistentStore persistentStore, String idYeld, String idFx) {
        this.dataMarketLoader = new DataMarketLoader(persistentStore, idYeld, idFx);

    }

   

    @Override
    public YieldCurve getYieldCurve() {

        if (cacheYieldCurve == null) {
            cacheYieldCurve = dataMarketLoader.getYieldCurve();
            return cacheYieldCurve;
        } else {
            return cacheYieldCurve;
        }

    }

    @Override
    public FxQuote getFxQuote() {

        if (cacheFxQuote == null) {
            cacheFxQuote = dataMarketLoader.getFxQuote();
            return cacheFxQuote;
        } else {
            return cacheFxQuote;
        }
    }
}
