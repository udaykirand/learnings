/**
 * 
 */
package com.taxcalc.service;

import java.util.List;

/**
 * @author Uday
 *
 */
public class TaxCalculatorImpl implements ITaxCalculator {

	/* (non-Javadoc)
	 * @see com.taxcalc.service.ITaxCalculator#calculateTax(java.util.List)
	 */
	/**
     * This is only point of contact of outside world Calculate Shopping Cart
     * Bill Users calculate records Bill (Once bill gets generate user can’t
     * add, edit, remove or calculate records.
     * @throws ShopingCartException
     */
    public void calculateTax(List<?> shopingCartInputDTOList)  {
        SalesTaxCalculatorIfc selesTaxCalculatorIfc = null;

        // Creating the ShoppingCart object using static factory
        selesTaxCalculatorIfc = ShopingCartFactory.getInstance(ShoppingCartconstantsIfc.SERVICE_TAXCALCULATORSERVICEIMPL);

        // calculate data
        try {
                    selesTaxCalculatorIfc.calculateTax(shopingCartInputDTOList);
        } catch (ShopingCartException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    //Logs exception into logging
        }

    }

}

