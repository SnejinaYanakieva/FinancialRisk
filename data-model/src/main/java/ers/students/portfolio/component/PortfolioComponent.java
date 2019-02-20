/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio.component;
import java.util.*;
import ers.students.utill.Currency;
/**
 *
 * @author Viktor
 */
public interface PortfolioComponent {
    
    
    
public String getId();
public String getParentId();
public Map<CalculationResult, Object> getCalculationResults();

public List<String> getErrors();
public void clearAllResults();
public String getName();
public Currency getCurrency();


}  

