package com.tax.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class INDIASlabRate extends CountrySlabRate {

	public INDIASlabRate(CountryType country) {
		super(country);
		slabRate();
	}
	static{
		investmentLimit = 150000.00;
		nonTaxableIncome = 250000.00;
	}

	 Map<Double, Float> taxRate = new LinkedHashMap<>();
	@Override
	protected  Map<Double, Float> slabRate() {
		// TODO Auto-generated method stub
		taxRate.put(250000.00, 0.0f);
		taxRate.put(500000.00, 0.10f);
		taxRate.put(1000000.00, 0.15f);
		taxRate.put(1500000.00, 0.20f);
		return taxRate;
	}
}
