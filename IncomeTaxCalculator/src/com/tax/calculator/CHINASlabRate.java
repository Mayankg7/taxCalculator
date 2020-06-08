package com.tax.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class CHINASlabRate extends CountrySlabRate {
	public CHINASlabRate(CountryType country) {
		super(country);
		slabRate();
	}

	protected static Double investmentLimit = 50000.00;

	protected static Double nonTaxableIncome = 100000.00;

	Map<Double, Float> taxRate = new LinkedHashMap<>();

	@Override
	protected Map<Double, Float> slabRate() {
		// TODO Auto-generated method stub
		taxRate.put(100000.00, 0.0f);
		taxRate.put(150000.00, 0.10f);
		taxRate.put(200000.00, 0.15f);
		return taxRate; 
	}
}
