package io.gate.impl;

import io.gate.GateApiAsyncRestClient;
import io.gate.domain.general.Asset;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Gate's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class GateApiAsyncRestClientImpl implements GateApiAsyncRestClient {

    private final GateApiService gateApiService;

    public GateApiAsyncRestClientImpl(GateApiService gateApiService) {
        this.gateApiService = gateApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<List<Asset>> getAssets() {
        CompletableFuture<List<Asset>> future = new CompletableFuture<>();
        gateApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
