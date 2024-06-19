package com.adepuu.bangjagobackend.xchange.service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

public interface CurrencyExchangeService {
    double getExchangeRate(String fromCurrency, String toCurrency, LocalDate date);
    double convertCurrency(String fromCurrency, String toCurrency, double amount, LocalDate date);
}
