package io.gate.impl;

import io.gate.GateApiClientFactory;
import io.gate.GateApiRestClient;
import io.gate.domain.account.Transaction;
import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;
import io.gate.domain.market.OrderBook;
import io.gate.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GateApiRestClientImplTest {

    private GateApiRestClient gateApiRestClient;

    @BeforeEach
    public void setUp() {
        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret);
        this.gateApiRestClient = GateApiClientFactory.newInstance(apiCredentials).newRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() {
        List<Asset> assets = gateApiRestClient.getAssets();
        assertThat(assets, is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() {
        List<MarketInfo> marketInfoList = gateApiRestClient.getMarketInfo();
        assertThat(marketInfoList, allOf(notNullValue(), is(not(empty()))));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        List<MarketTicker> marketTickers = gateApiRestClient.getMarketTickers();
        assertThat(marketTickers, allOf(notNullValue(), is(not(empty()))));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() {
        OrderBook orderBook = gateApiRestClient.getOrderBook("BTC_USDT", 0, 10, true);
        assertNotNull(orderBook);
        assertThat(orderBook.getAsks(), is(not(empty())));
        assertThat(orderBook.getBids(), is(not(empty())));
    }

    @Test
    public void getDeposits_ShouldReturnDeposits() {
        List<Transaction> deposits = gateApiRestClient.getDeposits(null, null, null, null, null);
    }
}