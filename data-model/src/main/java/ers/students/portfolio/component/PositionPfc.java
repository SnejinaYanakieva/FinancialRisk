/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;

import ers.students.portfolio.Position;
import ers.students.portfolio.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * A component of the portfolio
 *
 * @author Viktor
 */
public class PositionPfc extends AbstractPfc {

    private Position position;
    private double volume;
    private List<Transaction> transactionList = new ArrayList<>();  

    PositionPfc(Position position, double volume, List<Transaction> transactionList) {
        this.position = position;
        this.volume = volume;
        this.transactionList=transactionList;
    }

    PositionPfc() {
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    
    public  List<Transaction> getTransactionList() {
        return transactionList;
    }
      public  void addInTransactionList(Transaction forAdd) {
        transactionList.add(forAdd);
    }
}
