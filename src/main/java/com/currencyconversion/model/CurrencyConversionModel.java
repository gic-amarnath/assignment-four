package com.currencyconversion.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionModel {
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	
}
