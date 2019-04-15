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
 * Singleton class that provides a registry of AbstractCrudProvider classes.
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
    private PersistentStore persistentStore;
    
    /**
     * Creates objects of type AbstractCrudProvider.
     */
    private InstrumentCrudProvider instrument;
    private PositionCrudProvider position;
    private PortfolioCrudProvider portfolio;
    private FxCrudProvider fxQuote;
    private YieldCurveCrudProvider yieldCurve;
    private TransactionCrudProvider transaction;
    
    /**
     * Private constructor to prevent others from instantiating this class.
     */
    private ProviderRegistry() {
        }
    
    /**
     * Provide a global point of access to the instance.
     * 
     * @param store
     * @return returns the only object available
     */
    public static ProviderRegistry getInstance(){
        if(instance == null) {
            instance = new ProviderRegistry();
        }
        return instance;
    }

    public void setPersistentStore(PersistentStore store){
        persistentStore = store;
    }

    
    /**
     * @return an object of type InstrumentCrudProvider
     */
    public InstrumentCrudProvider getInstrumentProvider(){
        if(instrument == null){
            instrument = new InstrumentCrudProvider(persistentStore);
        }
        return instrument;
    }
    
    /**
     * @return an object of type PositionCrudProvider
     */
    public PositionCrudProvider getPositionProvider(){    
        if(position == null){
            position = new PositionCrudProvider(persistentStore);
        }
        return position;
    }
    
    /**
     * @return an object of type PortfolioCrudProvider
     */
    public PortfolioCrudProvider getPortfolioProvider(){    
        if(portfolio == null){
            portfolio = new PortfolioCrudProvider(persistentStore);
        }
        return portfolio;
    }

    /**
     * @return an object of type FxCrudProvider
     */
    public FxCrudProvider getFxQuoteProvider(){    
        if(fxQuote == null){
            fxQuote = new FxCrudProvider(persistentStore);
        }
        return fxQuote;
    }

    /**
     * @return an object of type YieldCurveCrudProvider
     */
    public YieldCurveCrudProvider getYieldCurveProvider(){    
        if(yieldCurve == null){
            yieldCurve = new YieldCurveCrudProvider(persistentStore);
        }
        return yieldCurve;
    }

    /**
     * @return an object of type TransactionCrudProvider
     */
    public TransactionCrudProvider getTransactionProvider(){    
        if(transaction == null){
            transaction = new TransactionCrudProvider(persistentStore);
        }
        return transaction;
    }
    
}
