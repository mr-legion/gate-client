package io.gate;

import io.gate.domain.account.Transaction;
import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;
import io.gate.domain.market.OrderBook;

import java.util.List;

/**
 * Gate API facade, supporting synchronous/blocking access Gate's REST API.
 */
public interface GateApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    List<Asset> getAssets();

    // Market endpoints

    /**
     * Get all supported markets.
     *
     * @return market info
     */
    List<MarketInfo> getMarketInfo();

    /**
     * Get market tickers information for all markets.
     *
     * @return market tickers
     */
    List<MarketTicker> getMarketTickers();

    /**
     * Get orderbook for the market.
     *
     * @param market   market symbol (e.g. BTC_USDT)
     * @param interval order depth. 0 means no aggregation is applied. default to 0.
     * @param limit    depth of the order book. Max depth 100
     * @param withId   return order book ID
     * @return orderbook
     */
    OrderBook getOrderBook(String market, Integer interval, Integer limit, Boolean withId);

    // Account endpoints

    /**
     * Get deposits records.
     *
     * @param asset  filter by asset symbol. Return all assets records if not specified.
     * @param from   time range beginning, default to 7 days before current time
     * @param to     time range ending, default to current time
     * @param limit  maximum number of records to be returned in a single list
     * @param offset list offset, starting from 0
     * @return deposits records
     */
    List<Transaction> getDeposits(String asset, Long from, Long to, Integer limit, Integer offset);

}