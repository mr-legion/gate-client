package io.gate;

import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;
import io.gate.domain.market.OrderBook;

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

    /**
     * Get orderbook for the market (asynchronous).
     *
     * @param market   market symbol (e.g. BTC_USDT)
     * @param interval order depth. 0 means no aggregation is applied. default to 0.
     * @param limit    depth of the order book. Max depth 100
     * @param withId   return order book ID
     * @return orderbook
     */
    CompletableFuture<OrderBook> getOrderBook(String market, Integer interval, Integer limit, Boolean withId);

}