/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.registry;

import ers.students.crud.provider.FxCrudProvider;
import ers.students.crud.provider.YieldCurveCrudProvider;
import ers.students.crud.provider.searching.InstrumentCrudProvider;
import ers.students.crud.provider.searching.PortfolioCrudProvider;
import ers.students.crud.provider.searching.PositionCrudProvider;
import ers.students.crud.provider.searching.TransactionCrudProvider;
import ers.students.persistentStore.PersistentStore;

/**
 *
 * @author martinstoynov
 */

public class ProviderRegistry {
    
    private static ProviderRegistry instance;
    private static PersistentStore persistentStore;
    
    private static InstrumentCrudProvider instrument;
    private static PositionCrudProvider position;
    private static PortfolioCrudProvider portfolio;
    private static FxCrudProvider fxQuote;
    private static YieldCurveCrudProvider yieldCurve;
    private static TransactionCrudProvider transaction;
    
    private ProviderRegistry() {}
    
    public static ProviderRegistry getInstance(PersistentStore store){
        if(instance == null) {
            instance = new ProviderRegistry();
            persistentStore = store;
        }
        return instance;
    }
    
    public static InstrumentCrudProvider getInstrumentProvider(){
        if(instrument == null){
            instrument = new InstrumentCrudProvider(persistentStore);
        }
        return instrument;
    }
    
    public static PositionCrudProvider getPositionProvider(){    
        if(position == null){
            position = new PositionCrudProvider(persistentStore);
        }
        return position;
    }
    
    public static PortfolioCrudProvider getProtfolioProvider(){    
        if(portfolio == null){
            portfolio = new PortfolioCrudProvider(persistentStore);
        }
        return portfolio;
    }

    public static FxCrudProvider getFxQuoteProvider(){    
        if(fxQuote == null){
            fxQuote = new FxCrudProvider(persistentStore);
        }
        return fxQuote;
    }

    public static YieldCurveCrudProvider getYieldCurveProvider(){    
        if(yieldCurve == null){
            yieldCurve = new YieldCurveCrudProvider(persistentStore);
        }
        return yieldCurve;
    }

    public static TransactionCrudProvider getTransactionProvider(){    
        if(transaction == null){
            transaction = new TransactionCrudProvider(persistentStore);
        }
        return transaction;
    }
    
}
