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
     *  
     * @param filePath
     * @return
     * @throws IOException
     */
    public static List<IInputFormBean> createCart(File file) throws IOException {
	BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
	List<IInputFormBean> inputs = new ArrayList<IInputFormBean>();
	String line = null;
	while ((line = bufferedReader.readLine()) != null) {
	    processLine(line, inputs);
	}
	bufferedReader.close();
	return inputs;
    }

    /*
     * This method processes each line and creates corresponding list of DTO objects 
     * 
     * */
    public static void processLine(String line, List<IInputFormBean> inputs) {
	if (Character.isDigit(line.charAt(0))) {
	    IInputFormBean ipBean = new TaxInputForm();
	    String arr[] = line.split("((?<=:)|(?=:))|( )");

	    ipBean.setProductPrice(new BigDecimal(arr[arr.length - 1]));
	    ipBean.setQuantity(new Integer(arr[0]));
	    ipBean.setProductName(line.substring(2, line.indexOf(" at ")));

	    if (line.contains("choc") || line.contains("pills")|| line.contains("book")) {
		ipBean.setExemptTax(true);
		if (line.contains("import"))
		    ipBean.setImportTax(true);
	    } else {
		ipBean.setExemptTax(false);
		ipBean.setOnlySalesTax(true);
		if (line.contains("import"))
		    ipBean.setImportTax(true);
	    }
	    inputs.add(ipBean);
	}
    }
}
