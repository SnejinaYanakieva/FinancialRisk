/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.loader;

import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ayhan
 */
public class PositionTransactionLoader {
    
    private final String SELECT = "SELECT Position.*, Transaction.* FROM Portfolio JOIN ... WHERE Portfolio.id=?";
    
    public Map<Position, List<Transaction>> loadPositionTransactions (String portfolioId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
