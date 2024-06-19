package com.adepuu.bangjagobackend.xchange;

import com.adepuu.bangjagobackend.response.Response;
import com.adepuu.bangjagobackend.xchange.dto.CurrencyExchangeRequestDto;
import com.adepuu.bangjagobackend.xchange.dto.CurrencyExchangeResponse;
import com.adepuu.bangjagobackend.xchange.service.CurrencyExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exchange")
public class ExchangeController {
    private final CurrencyExchangeService exchangeService;

    public ExchangeController(CurrencyExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convertCurrency(@RequestBody CurrencyExchangeRequestDto request) {
        var pair = request.getPair().split("/");
        var resp = new CurrencyExchangeResponse(exchangeService.convertCurrency(pair[0], pair[1], request.getAmount(), request.getDate()));
        return Response.success("Success Converting Currency", resp);
    }
}
