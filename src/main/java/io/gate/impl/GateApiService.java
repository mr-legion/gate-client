package io.gate.impl;

import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Gate's REST API URL mappings.
 */
public interface GateApiService {

    // General endpoints

    @GET("/api/v4/spot/currencies")
    Call<List<Asset>> getAssets();

    // Market endpoints

    @GET("/api/v4/spot/currency_pairs")
    Call<List<MarketInfo>> getMarketInfo();

    @GET("/api/v4/spot/tickers")
    Call<List<MarketTicker>> getMarketTickers();
}
