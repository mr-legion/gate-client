package io.gate.impl;

import io.gate.GateApiAsyncRestClient;
import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;
import io.gate.domain.market.OrderBook;

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

    // Market endpoints

    @Override
    public CompletableFuture<List<MarketInfo>> getMarketInfo() {
        CompletableFuture<List<MarketInfo>> future = new CompletableFuture<>();
        gateApiService.getMarketInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<List<MarketTicker>> getMarketTickers() {
        CompletableFuture<List<MarketTicker>> future = new CompletableFuture<>();
        gateApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<OrderBook> getOrderBook(String market, Integer interval, Integer limit, Boolean withId) {
        CompletableFuture<OrderBook> future = new CompletableFuture<>();
        gateApiService.getOrderBook(market, interval, limit, withId).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
