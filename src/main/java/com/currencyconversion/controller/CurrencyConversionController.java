	package com.currencyconversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.currencyconversion.model.CurrencyConversionModel;
import com.currencyconversion.service.CurrencyConversionService;

@RestController
@RequestMapping("/api")
public class CurrencyConversionController {
	@Autowired
	private CurrencyConversionService currencyConversionService;

	@GetMapping("/converter/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<BigDecimal> convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversionModel model;
		try {
			model = currencyConversionService.convertCurrency(quantity, from, to);
			//System.out.println(">>>>>> "+model.getTotalCalculatedAmount());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), e);
		}
		return ResponseEntity.ok(model.getTotalCalculatedAmount());
	}
}
