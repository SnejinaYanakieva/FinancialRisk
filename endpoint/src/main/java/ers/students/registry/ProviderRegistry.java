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
    
    /**
     * Creates an object of type ProviderRegistry.
     */
    private static ProviderRegistry instance;
    
    /**
     * Creates an object of type PersistentStore.
     */
    private static PersistentStore persistentStore;
    
    /**
     * Create objects of type AbstractCrudProvider.
     */
    private static InstrumentCrudProvider instrument;
    private static PositionCrudProvider position;
    private static PortfolioCrudProvider portfolio;
    private static FxCrudProvider fxQuote;
    private static YieldCurveCrudProvider yieldCurve;
    private static TransactionCrudProvider transaction;
    
    /**
     * Private constructor to prevent others from instantiating this class.
     */
    private ProviderRegistry() {}
    
    /**
     * Provide a global point of access to the instance.
     * @param store
     * @return returns the only object available
     */
    public static ProviderRegistry getInstance(PersistentStore store){
        if(instance == null) {
            instance = new ProviderRegistry();
            persistentStore = store;
        }
        return instance;
    }
    
    /**
     * @return an object of type InstrumentCrudProvider
     */
    public static InstrumentCrudProvider getInstrumentProvider(){
        if(instrument == null){
            instrument = new InstrumentCrudProvider(persistentStore);
        }
        return instrument;
    }
    
    /**
     * @return an object of type PositionCrudProvider
     */
    public static PositionCrudProvider getPositionProvider(){    
        if(position == null){
            position = new PositionCrudProvider(persistentStore);
        }
        return position;
    }
    
    /**
     * @return an object of type PortfolioCrudProvider
     */
    public static PortfolioCrudProvider getProtfolioProvider(){    
        if(portfolio == null){
            portfolio = new PortfolioCrudProvider(persistentStore);
        }
        return portfolio;
    }

    /**
     * @return an object of type FxCrudProvider
     */
    public static FxCrudProvider getFxQuoteProvider(){    
        if(fxQuote == null){
            fxQuote = new FxCrudProvider(persistentStore);
        }
        return fxQuote;
    }

    /**
     * @return an object of type YieldCurveCrudProvider
     */
    public static YieldCurveCrudProvider getYieldCurveProvider(){    
        if(yieldCurve == null){
            yieldCurve = new YieldCurveCrudProvider(persistentStore);
        }
        return yieldCurve;
    }

    /**
     * @return an object of type TransactionCrudProvider
     */
    public static TransactionCrudProvider getTransactionProvider(){    
        if(transaction == null){
            transaction = new TransactionCrudProvider(persistentStore);
        }
        return transaction;
    }
    
}
