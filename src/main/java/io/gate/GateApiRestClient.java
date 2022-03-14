package io.gate;

import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;

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

}