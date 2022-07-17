package com.currencyconversion.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.currencyconversion.model.ExchangeRate;
import com.currencyconversion.model.ExchangeRateModel;
import com.currencyconversion.repo.ExchangeRateRepository;

@Service
public class ExchangeRateService {
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	public List<ExchangeRateModel> listExchangeRates() {
		List<ExchangeRate> exchangeRateList = exchangeRateRepository.findAll();
		return exchangeRateList.stream().map(ExchangeRateService::assembleExchangeRateModel).collect(Collectors.toList());
	}

	public List<ExchangeRateModel> listExchangeRatesByPage(final Pageable pageable) {
		Page<ExchangeRate> exchangeRateList = exchangeRateRepository.findAll(pageable);
		return exchangeRateList.stream().map(ExchangeRateService::assembleExchangeRateModel).collect(Collectors.toList());
	}
	
	  private static ExchangeRateModel assembleExchangeRateModel(ExchangeRate exchangeRateEntity) {
	        return new ExchangeRateModel(exchangeRateEntity.getId(), exchangeRateEntity.getCurrencyCode(), exchangeRateEntity.getRate().stripTrailingZeros());//, exchangeRateEntity.getCreated(), exchangeRateEntity.getLastUpdated());
	    }
	  
	   public ExchangeRateModel findByCurrencyCode(String currencyCode) throws Exception {
	        ExchangeRateModel exchangeRateModel = null;
	        Optional<ExchangeRate> exchangeRateEntity = exchangeRateRepository.findByCurrencyCode(currencyCode);
	        if (exchangeRateEntity.isPresent()) {
	            ExchangeRate c = exchangeRateEntity.get();
	            exchangeRateModel = assembleExchangeRateModel(c);
	        }
	        else {
	    		throw new Exception(currencyCode);
	        }
	        return exchangeRateModel;
	    }

}
