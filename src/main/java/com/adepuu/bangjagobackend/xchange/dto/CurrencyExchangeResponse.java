package com.adepuu.bangjagobackend.xchange.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeResponse {
    private double convertedAmount;
}
