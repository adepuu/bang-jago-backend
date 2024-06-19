package com.adepuu.bangjagobackend.xchange.grpc;

import com.adepuu.bangjagobackend.xchange.service.CurrencyExchangeService;
import com.adepuu.grpcinterface.lib.ExchangeRequest;
import com.adepuu.grpcinterface.lib.ExchangeResponse;
import com.adepuu.grpcinterface.lib.CurrencyExchangeGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.java.Log;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDate;

/**
 * Example grpc server currency exchange service implementation class.
 */
@Log
@GrpcService
public class ExchangeGrpcServer extends CurrencyExchangeGrpc.CurrencyExchangeImplBase {
    private final CurrencyExchangeService exchangeService;

    public ExchangeGrpcServer(CurrencyExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @Override
    public void getExchangeAmount(final ExchangeRequest req, final StreamObserver<ExchangeResponse> responseObserver) {
        log.info("Received exchange request: " + req.toString());
        var pair = req.getPair().split("/");
        LocalDate date = LocalDate.parse(req.getDate());
        var result = exchangeService.convertCurrency(pair[0], pair[1], req.getAmount(), date);
        final ExchangeResponse resp = ExchangeResponse.newBuilder().setExchangedAmount(result).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}