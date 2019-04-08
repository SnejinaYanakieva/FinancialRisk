/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud;

import ers.students.persistentStore.PersistentStore;
import ers.students.portfolio.Transaction;

/**
 *
 * @author Ayhan
 * 
 * Stores data retrieved from CRUD operations
 */
public class TransactionDao extends AbstractSearchingDao<Transaction> {
    
    public TransactionDao(PersistentStore ps) {
        super(ps);
    }
    
}
