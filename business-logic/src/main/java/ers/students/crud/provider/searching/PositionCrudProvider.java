/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.provider.searching;

import ers.students.crud.CrudDao;
import ers.students.crud.results.LoadResults;
import ers.students.portfolio.Position;

/**
 *
 * @author Irina
 */
public class PositionCrudProvider extends SearchingCrudProvider<Position> {

    /**
     * Provides DAO interface for Position.
     *
     * @return
     */
    @Override
    public CrudDao<Position> getDao() {
        return persistentStore.getPositionDao();
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public LoadResults<Position> searchByName(String name) {
        LoadResults<Position> positionResults = new LoadResults<>();
        positionResults.setEntities(persistentStore.getPositionDao().searchByName(name));
        return positionResults;
    }
}
