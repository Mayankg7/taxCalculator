package com.tax.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class USASlabRate extends CountrySlabRate {
	public USASlabRate(CountryType country) {
		super(country);
		slabRate();
	}

	protected static Double investmentLimit = 1000.00;

	protected static Double nonTaxableIncome = 3000.00;

	Map<Double, Float> taxRate = new LinkedHashMap<>();

	@Override
	protected Map<Double, Float> slabRate() {
		// TODO Auto-generated method stub
		taxRate.put(3000.00, 0.0f);
		taxRate.put(4000.00, 0.20f);
		return taxRate;
	}
}
