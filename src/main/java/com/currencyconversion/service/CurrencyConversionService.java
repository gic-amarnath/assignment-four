package com.currencyconversion.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currencyconversion.model.CurrencyConversionModel;
import com.currencyconversion.model.ExchangeRateModel;

@Service
public class CurrencyConversionService {
	   @Autowired
	    private ExchangeRateService exchangeRateService;
	    
	    public CurrencyConversionModel convertCurrency(BigDecimal fromQuantity, String from, String to) throws Exception {
	    	final ExchangeRateModel fromModel = exchangeRateService.findByCurrencyCode(from);
	    	final ExchangeRateModel toModel = exchangeRateService.findByCurrencyCode(to);
	    	return new CurrencyConversionModel(from, to, fromQuantity, fromQuantity.multiply(fromModel.getRate()).divide(toModel.getRate(), 18, RoundingMode.HALF_UP));
	    }
}
