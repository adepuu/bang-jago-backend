package com.adepuu.bangjagobackend.xchange.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeRequestDto {
    private String pair;
    private double amount;
    private LocalDate date;
}
