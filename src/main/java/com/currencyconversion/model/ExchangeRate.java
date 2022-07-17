package com.currencyconversion.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="currency_exchange_rate")
public class ExchangeRate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NaturalId
	@NotBlank
	@Column(name = "currency_code", unique = true, nullable = false, length = 3)
	private String currencyCode;

	@Positive
	@Column(nullable = false, precision = 32, scale = 18)
	private BigDecimal rate;
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExchangeRate that = (ExchangeRate) o;
		return Objects.equals(currencyCode, that.currencyCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(currencyCode);
	}
}
