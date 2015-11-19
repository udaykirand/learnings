package com.taxcalc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.model.TaxInputForm;

public class InputProcessor {
	
	/**
	 * if file path is specified that is picked up else by default Input inside
	 * the same package is pickedup. Each line is picked up and served to
	 * processLine() for processing.
	 * 
	 * @param filePath
	 * @return 
	 * @throws IOException
	 */
	public static List<IInputFormBean> prepareModel(File file) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		List<IInputFormBean> inputs = new ArrayList<IInputFormBean>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			processLine(line, inputs);
		}
		bufferedReader.close();
		return inputs;
	}

	public static void processLine(String line, List<IInputFormBean> inputs) {
		if (Character.isDigit(line.charAt(0))) {
			IInputFormBean ipBean = new TaxInputForm();
			String arr[] = line.split("((?<=:)|(?=:))|( )");
			
			ipBean.setGoodsPrice(new BigDecimal(arr[arr.length - 1]));
			ipBean.setGoodsquontity(new Integer(arr[0]));
			ipBean.setGoodsName(line.substring(2, line.indexOf(" at ")));
			
			if(line.contains("choc") || line.contains("pills")) {
				if(line.contains("import"))
					ipBean.setAdditionalImportedTaxPercentage(true);
				else
					ipBean.setExemptTax(true);
			} else {
				ipBean.setExemptTax(true);
				ipBean.setAdditionalImportedTaxPercentage(true);
			}
			inputs.add(ipBean);
		}
	}
}
