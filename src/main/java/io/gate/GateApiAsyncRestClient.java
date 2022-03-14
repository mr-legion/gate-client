package io.gate;

import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Gate API facade, supporting asynchronous/non-blocking access Gate's REST API.
 */
public interface GateApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<List<Asset>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets (asynchronous).
     *
     * @return markets info
     */
    CompletableFuture<List<MarketInfo>> getMarketInfo();

    /**
     * Get market tickers information for all markets (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<List<MarketTicker>> getMarketTickers();

}