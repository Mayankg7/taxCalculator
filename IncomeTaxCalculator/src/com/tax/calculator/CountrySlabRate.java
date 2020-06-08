package com.tax.calculator;

import java.util.Map;

public abstract class CountrySlabRate {

	public CountrySlabRate(CountryType model) {
		this.country = model;
	}

	// Do subclass level processing in this method
	protected abstract Map<Double, Float> slabRate();

	private CountryType country = null;
	protected static double nonTaxableIncome;
	protected static double investmentLimit;

	public CountryType getCountry() {
		return country;
	}

	public void setCountry(CountryType country) {
		this.country = country;
	}
}
