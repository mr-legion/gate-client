package io.gate.impl;

import io.gate.GateApiAsyncRestClient;
import io.gate.GateApiClientFactory;
import io.gate.domain.account.Transaction;
import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;
import io.gate.domain.market.OrderBook;
import io.gate.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GateApiAsyncRestClientImplTest {

    private GateApiAsyncRestClient gateApiAsyncRestClient;

    @BeforeEach
    public void setUp() {
        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret);
        this.gateApiAsyncRestClient = GateApiClientFactory.newInstance(apiCredentials).newAsyncRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        List<Asset> assets = gateApiAsyncRestClient.getAssets().get();
        assertThat(assets, is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() throws ExecutionException, InterruptedException {
        List<MarketInfo> marketInfoList = gateApiAsyncRestClient.getMarketInfo().get();
        assertThat(marketInfoList, allOf(notNullValue(), is(not(empty()))));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() throws ExecutionException, InterruptedException {
        List<MarketTicker> marketTickers = gateApiAsyncRestClient.getMarketTickers().get();
        assertThat(marketTickers, allOf(notNullValue(), is(not(empty()))));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() throws ExecutionException, InterruptedException {
        OrderBook orderBook = gateApiAsyncRestClient.getOrderBook("BTC_USDT", 0, 10, true).get();
        assertNotNull(orderBook);
        assertThat(orderBook.getAsks(), is(not(empty())));
        assertThat(orderBook.getBids(), is(not(empty())));
    }

    @Test
    public void getDeposits_ShouldReturnDeposits() throws ExecutionException, InterruptedException {
        List<Transaction> deposits = gateApiAsyncRestClient.getDeposits(null, null, null, null, null).get();
    }
}