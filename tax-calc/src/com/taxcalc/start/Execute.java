package com.taxcalc.start;

import java.io.File;
import java.util.List;
import java.util.Properties;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.service.InputProcessor;
import com.taxcalc.service.TaxCalculatorImpl;
import com.taxcalc.service.impl.ITaxCalculator;
import com.taxcalc.util.Util;

/**
 * 
 * This is the starting point of execution and reads inputs from 'input' directory in the form of files 
 * and passes it to InputProcessor for validations. If the input is valid, creates the DTO object for cart 
 * and passes it to {@link ITaxCalculator#prepareBillForCart(List, Properties)} 
 * @author Uday
 * 
 */
public class Execute {

    public static void main(String[] args) {

	try {
	    File dir = new File("input");
	    File[] directoryListing = dir.listFiles();
	    //Here we read the all tax rules to be used
	    Properties properties = Util.readProperties();
	    int cartCount = 1;
	    if (directoryListing != null) {
		for (File file : directoryListing) {
		    List<IInputFormBean> cart = InputProcessor.createCart(file);
		    ITaxCalculator pointOfSale = new TaxCalculatorImpl();
		    pointOfSale.prepareBillForCart(cart, properties, cartCount++);
		}
	    }
	} catch (Exception e) {
	    System.err.println("Exception occured " + e);
	    e.printStackTrace();
	}

    }

}
