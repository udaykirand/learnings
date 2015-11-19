package com.taxcalc.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.model.TaxInputForm;

/**
 * Following class contains utility methods
 * 
 * @author Uday
 * 
 */
public class Util {

	/**
	 * Following method is used to read properties file read properties file
	 * 
	 * @param keyValue
	 * @return
	 * @throws ShopingCartException
	 */
	public static String readProperties(String keyValue)
			throws ShopingCartException {
		Properties prop = new Properties();
		FileInputStream fis = null;
		String propertiesKey = null;
		try {
			fis = new FileInputStream(Constants.PROPERTIES_URL);
			prop.load(fis);
			// get value from key
			propertiesKey = prop.getProperty(keyValue);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Will handle Try.catch writing my own exception handler
				e.printStackTrace();
				throw new ShopingCartException("Issue in reading Filet");
			}
		}
		return propertiesKey;
	}

	/**
	 * Following method is using to set result into InputDataDTO object
	 * 
	 * @param inputDataDTO
	 * @param salesTax
	 * @return
	 */
	public static List<IInputFormBean> convertDto(IInputFormBean inputDataDTO,
			BigDecimal salesTax, List<IInputFormBean> processedCart) {

		TaxInputForm newInputDataDTO = new TaxInputForm();

		newInputDataDTO.setAdditionalImportedTaxPercentage(inputDataDTO
				.isAdditionalImportedTaxPercentage());
		newInputDataDTO.setCalculateTaxPercentage(salesTax);
		newInputDataDTO.setDomesticTaxPercentage(inputDataDTO
				.isDomesticTaxPercentage());
		newInputDataDTO.setExemptTax(inputDataDTO.isExemptTax());
		newInputDataDTO.setGoodsName(inputDataDTO.getGoodsName());
		newInputDataDTO.setGoodsPrice(inputDataDTO.getGoodsPrice());
		newInputDataDTO.setGoodsquontity(inputDataDTO.getGoodsquontity());
		// Added into List
		processedCart.add(newInputDataDTO);

		return processedCart;
	}
}
