package com.taxcalc.service;

import com.taxcalc.service.impl.ISalesTaxCalculator;

/**
 * This is Static Factory for Object creation. Currently its creating only ServiceTaxCalculatorImpl object but if in future required to decorate any object then factory would help it modify it easily.
 * 
 * @author Uday
 * 
 */
public class CalculatorFactory {
    private static ISalesTaxCalculator taxCalc = null;

    // made class immutable
    private CalculatorFactory() {
    }

    /**
     * following method will return instance of CalculatorFactory. Currently single thread is accessing instance so no need synchronization
     * 
     * @param type
     * @return
     */
    public static ISalesTaxCalculator getInstance() {
	if (taxCalc == null) {
	    taxCalc = new SalesTaxCalculatorImpl();
	}
	return taxCalc;
    }
}
