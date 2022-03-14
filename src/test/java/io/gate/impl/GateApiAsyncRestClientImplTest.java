package io.gate.impl;

import io.gate.GateApiAsyncRestClient;
import io.gate.GateApiClientFactory;
import io.gate.domain.general.Asset;
import io.gate.domain.market.MarketInfo;
import io.gate.domain.market.MarketTicker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GateApiAsyncRestClientImplTest {

    private final GateApiAsyncRestClient gateApiAsyncRestClient = GateApiClientFactory.newInstance().newAsyncRestClient();

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
}