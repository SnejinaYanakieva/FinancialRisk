/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

import ers.students.crud.provider.FxCrudProvider;
import ers.students.crud.provider.YieldCurveCrudProvider;
import ers.students.crud.results.LoadResult;
import ers.students.persistentStore.JdbcPersistentStore;

/**
 *
 * @author Viktor
 */
public class DataMarketLoader implements Market {
    
    
        private String dbURL ;
        private String userName; 
        private String password;

    public DataMarketLoader(String dbURL, String userName, String password) {
        this.dbURL = dbURL;
        this.userName = userName;
        this.password = password;
    }
        
             
        

    @Override
    public YieldCurve getYieldCurve() {
       
        JdbcPersistentStore store = new JdbcPersistentStore(dbURL, userName, password);
        YieldCurveCrudProvider yeldCurveProvider = new YieldCurveCrudProvider(store);
        LoadResult<YieldCurve> curve = yeldCurveProvider.loadById(dbURL);

        return curve.getEntity();
    }

    @Override
    public FxQuote getFxQuote() {
      
        JdbcPersistentStore store = new JdbcPersistentStore(dbURL, userName, password);
        FxCrudProvider fxCurveProvider = new FxCrudProvider(store);
      LoadResult<FxQuote> fxQuote = fxCurveProvider.loadById(dbURL);
       
        
        
        return fxQuote.getEntity();
    }

}
