/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.CrudDao;
import ers.students.instruments.Instrument;

/**
 *
 * @author Irina
 */
public class InstrumentCrudProvider extends SearchingCrudProvider {

    /**
     * Provides DAO interface for Instrument.
     *
     * @return
     */
    CrudDao<Instrument> getDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
