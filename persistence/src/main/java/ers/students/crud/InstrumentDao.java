/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.instruments.Instrument;
import ers.students.persistentStore.PersistentStore;

/**
 *
 * @author Ayhan
 * 
 * Stores data retrieved from CRUD operations
 */
public class InstrumentDao extends AbstractSearchingDao<Instrument>{
    
    public InstrumentDao(PersistentStore ps) {
        super(ps);
    }
    
}
