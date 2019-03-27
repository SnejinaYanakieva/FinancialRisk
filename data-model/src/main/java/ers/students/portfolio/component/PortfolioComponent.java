/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;

import java.util.*;
import ers.students.util.Currency;

/**
 * Interface of the portfolio component
 *
 * @author Viktor
 */
public interface PortfolioComponent {

    String getId();

    String getParentId();

    Map<CalculationResult, Object> getCalculationResults();

    List<String> getErrors();

    void clearAllResults();

    String getName();

    Currency getCurrency();

}
