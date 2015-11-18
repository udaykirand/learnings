/**
 * 
 */
package com.taxcalc.service;

import java.util.List;

/**
 * @author Uday
 *
 */
public interface SalesTaxCalculatorIfc {
	/**
     * following class is single point of entry of outside world
     * @param shopingCartInputDTOList
     * @throws ShopingCartException
     */
    public void calculateTax(List<?> shopingCartInputDTOList) throws ShopingCartException;
    /**
     * Displaying result as per user requirement
     * @param shopingCartInputDTOList
     */
    public  void displayBill(List<?> shopingCartInputDTOList);
    /**
     * calculate tax
     * @param shopingCartInputDTOList
     * @return
     * @throws ShopingCartException
     */
    public  List<InputDataDTO> calculateTaxPercentage(List<?> shopingCartInputDTOList) throws ShopingCartException ;
}
