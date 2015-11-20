package com.taxcalc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.model.TaxInputForm;
import com.taxcalc.service.ShopingCartException;

/**
 * Class contains utility methods
 * 
 * @author Uday
 * 
 */
public class Util {

    /**
     * Method to read tax rules from properties file
     * 
     * @return taxRules
     * @throws ShopingCartException
     */
    public static Properties readProperties() throws ShopingCartException {
	Properties properties = new Properties();
	FileInputStream ipStream = null;
	try {
	    ipStream = new FileInputStream(Constants.PROPERTIES_URL);
	    properties.load(ipStream);
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		ipStream.close();
	    } catch (IOException e) {
		throw new ShopingCartException("Properties File not available!!");
	    }
	}
	return properties;
    }

    /**
     * Method used to set result into DTO
     * 
     * @param lineItem
     * @param salesTax
     * @param processedCart
     * @return processedCart
     */
    public static List<IInputFormBean> convertDto(IInputFormBean lineItem, BigDecimal salesTax, List<IInputFormBean> processedCart) {

	TaxInputForm processedItem = new TaxInputForm();

	processedItem.setAddnlImportTax(lineItem.isAddnlImportTax());
	processedItem.setCalculatedTax(salesTax);
	processedItem.setOnlySalesTax(lineItem.isOnlySalesTax());
	processedItem.setExemptTax(lineItem.isExemptTax());
	processedItem.setProductName(lineItem.getProductName());
	processedItem.setProductPrice(lineItem.getProductPrice());
	processedItem.setQuantity(lineItem.getQuantity());

	processedCart.add(processedItem);

	return processedCart;
    }
}
