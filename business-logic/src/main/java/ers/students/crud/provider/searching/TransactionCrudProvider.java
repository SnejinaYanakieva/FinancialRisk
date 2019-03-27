/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.SearchingDao;
import ers.students.portfolio.Transaction;

/**
 *
 * @author Irina
 */
public class TransactionCrudProvider extends SearchingCrudProvider<Transaction> {

    /**
     * Provides DAO interface for Transaction.
     *
     * @return
     */
    @Override
    public SearchingDao<Transaction> getDao() {
        return persistentStore.getTransactionDao();
    }

}
