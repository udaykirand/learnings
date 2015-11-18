package com.taxcalc.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

/**
 * Following class contains utility methods
 * 
 * @author Vaquar Khan
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
			fis = new FileInputStream(ShoppingCartconstantsIfc.PROPERTIES_URL);
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
	public static List<InputDataDTO> convertDto(InputDataDTO inputDataDTO,
			BigDecimal salesTax, List<InputDataDTO> newShopingCartInputDTOList) {

		InputDataDTO newInputDataDTO = new InputDataDTO();

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
		newShopingCartInputDTOList.add(newInputDataDTO);

		return newShopingCartInputDTOList;
	}
}
