package com.adepuu.bangjagobackend.xchange.repository;

import com.adepuu.bangjagobackend.xchange.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    Optional<CurrencyExchange> findByBaseCurrencyAndTargetCurrencyAndCreatedAtBetween(String baseCurrency, String targetCurrency, Instant startDate, Instant endDate);
}
