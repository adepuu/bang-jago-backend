package com.adepuu.bangjagobackend.xchange.service.impl;

import com.adepuu.bangjagobackend.exception.DataNotFoundException;
import com.adepuu.bangjagobackend.xchange.repository.CurrencyExchangeRepository;
import com.adepuu.bangjagobackend.xchange.service.CurrencyExchangeService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
    private final CurrencyExchangeRepository exchangeRepository;

    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }


    @Override
    public double getExchangeRate(String fromCurrency, String toCurrency, LocalDate date) {
        return 0;
    }

    @Override
    public double convertCurrency(String fromCurrency, String toCurrency, double amount, LocalDate date) {
        ZoneId zoneId = ZoneId.systemDefault();

        Instant startOfDay = date.atStartOfDay(zoneId).toInstant();
        Instant endOfDay = date.atTime(LocalTime.MAX).atZone(zoneId).toInstant();
        var exchangeRate = exchangeRepository.findByBaseCurrencyAndTargetCurrencyAndCreatedAtBetween(fromCurrency, toCurrency, startOfDay, endOfDay).orElseThrow(() -> new DataNotFoundException("Exchange rate not found")).getAverageRate();
        return amount * exchangeRate;
    }
}
