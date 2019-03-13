/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

/**
 *Interface for the FxQuote and YeldCurve getters
 * @author Viktor
 */
public interface Market {

    YieldCurve getYieldCurve();

    FxQuote getFxQuote();
}
