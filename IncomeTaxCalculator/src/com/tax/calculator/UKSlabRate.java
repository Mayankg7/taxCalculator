package com.tax.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class UKSlabRate extends CountrySlabRate {
	public UKSlabRate(CountryType country) {
		super(country);
		slabRate();
	}

	protected static Double investmentLimit = 5000.00;

	protected static Double nonTaxableIncome = 10000.00;

	private Map<Double, Float> taxRate = new LinkedHashMap<>();

	@Override
	protected Map<Double, Float> slabRate() {
		taxRate.put(10000.00, 0.0f);
		taxRate.put(20000.00, 0.10f);
		taxRate.put(30000.00, 0.20f);
		taxRate.put(40000.00, 0.30f);
		return taxRate;
	}
}
