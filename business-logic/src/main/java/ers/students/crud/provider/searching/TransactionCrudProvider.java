/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.CrudDao;
import ers.students.portfolio.Transaction;

/**
 *
 * @author Irina
 */
public class TransactionCrudProvider extends SearchingCrudProvider {

    /**
     * Provides DAO interface for Transaction.
     *
     * @return
     */
    CrudDao<Transaction> getDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
