/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

/**
 *
 * @author Viktor
 */
public class CachingMarket implements Market {

    String dbURL;
    String userName;
    String password;

    private DataMarketLoader dataMarketLoader = new DataMarketLoader(dbURL, userName, password);
    private YieldCurve cacheYieldCurve = new YieldCurve(); //cacheYieldCurve = dataMarketLoader.getYieldCurve();
    private FxQuote cacheFxQuote = new FxQuote(); //dataMarketLoader.getFxQuote();

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
