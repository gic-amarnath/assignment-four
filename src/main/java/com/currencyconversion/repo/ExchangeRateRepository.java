package com.currencyconversion.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyconversion.model.ExchangeRate;


public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
	Optional<ExchangeRate> findByCurrencyCode(String currencyCode);
}
