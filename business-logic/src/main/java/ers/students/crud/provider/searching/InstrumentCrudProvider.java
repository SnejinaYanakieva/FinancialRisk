/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.CrudDao;
import ers.students.crud.results.LoadResults;
import ers.students.instruments.Instrument;

/**
 *
 * @author Irina
 */
public class InstrumentCrudProvider extends SearchingCrudProvider<Instrument> {

    /**
     * Provides DAO interface for Instrument.
     *
     * @return
     */
    @Override
    public CrudDao<Instrument> getDao() {
        return persistentStore.getInstrumentDao();
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public LoadResults<Instrument> searchByName(String name) {
        LoadResults<Instrument> instrumentResults = new LoadResults<>();
        instrumentResults.setEntities(persistentStore.getInstrumentDao().searchByName(name));
        return instrumentResults;
    }

}
