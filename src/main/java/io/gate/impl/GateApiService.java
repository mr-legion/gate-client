package io.gate.impl;

import io.gate.domain.account.Transaction;
import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;
import io.gate.domain.market.OrderBook;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

import static io.gate.constant.GateApiConstants.AUTHORIZATION_REQUIRED_HEADER;

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

    @GET("/api/v4/spot/order_book")
    Call<OrderBook> getOrderBook(@Query("currency_pair") String market,
                                 @Query("interval") Integer interval,
                                 @Query("limit") Integer limit,
                                 @Query("with_id") Boolean withId);

    // Account endpoints

    @Headers(AUTHORIZATION_REQUIRED_HEADER)
    @GET("/api/v4/wallet/deposits")
    Call<List<Transaction>> getDeposits(@Query("currency") String asset,
                                        @Query("from") Long from,
                                        @Query("to") Long to,
                                        @Query("limit") Integer limit,
                                        @Query("offset") Integer offset);

}
