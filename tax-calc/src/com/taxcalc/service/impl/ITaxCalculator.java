/**
 * 
 */
package com.taxcalc.service.impl;

import java.util.List;
import java.util.Properties;

import com.taxcalc.model.IInputFormBean;

/**
 * @author Uday
 *
 */
public interface ITaxCalculator {
    /**
     * calculates bill for a list of items using the properties. This class can be enhanced if new type of items or new tax rules comes in
     * 
     * @param shopingCartInputDTOList
     * @param properties
     * @param cartCount 
     */

    public void prepareBillForCart(List<IInputFormBean> shopingCartInputDTOList, Properties properties, int cartCount);
}
