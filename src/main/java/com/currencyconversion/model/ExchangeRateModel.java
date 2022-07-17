package com.currencyconversion.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ExchangeRateModel {
	  private Long id;

	    @NotBlank(message = "{exchangeRate.currencyCode.required}")
	    private String currencyCode;

		@Positive(message = "{exchangeRate.rate.positive}")
	    @NotNull(message = "{exchangeRate.rate.required}")
	    private BigDecimal rate;

	    public ExchangeRateModel(String currencyCode, BigDecimal rate) {
	        this.currencyCode = currencyCode;
	        this.rate = rate;
	    }
	    //, LocalDateTime created, LocalDateTime lastUpdated

	    public ExchangeRateModel(Long id, String currencyCode, BigDecimal rate) {
	        this.id = id;
	        this.currencyCode = currencyCode;
	        this.rate = rate;
//	        this.created = created;
//	        this.lastUpdated = lastUpdated;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        ExchangeRateModel that = (ExchangeRateModel) o;
	        return Objects.equals(id, that.id) &&
	                Objects.equals(currencyCode, that.currencyCode);
	                //&&
//	                Objects.equals(rate, that.rate); &&
//	                Objects.equals(created, that.created) &&
//	                Objects.equals(lastUpdated, that.lastUpdated);
	    }

	    @Override
	    public int hashCode() {
	    	//, created, lastUpdated
	        return Objects.hash(id, currencyCode, rate);
	    }

		@Override
		public String toString() {
			//, created, lastUpdated
			return String.format("ExchangeRateModel [id=%s, currencyCode=%s, rate=%s, created=%s, lastUpdated=%s]", id,
					currencyCode, rate);
		}
}
