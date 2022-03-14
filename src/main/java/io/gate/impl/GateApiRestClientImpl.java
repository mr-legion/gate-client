package io.gate.impl;

import io.gate.GateApiRestClient;
import io.gate.domain.general.Asset;

import java.util.List;

import static io.gate.impl.GateApiServiceGenerator.executeSync;

/**
 * Implementation of Gate's REST API using Retrofit with synchronous/blocking method calls.
 */
public class GateApiRestClientImpl implements GateApiRestClient {

    private final GateApiService gateApiService;

    public GateApiRestClientImpl(GateApiService gateApiService) {
        this.gateApiService = gateApiService;
    }

    // General endpoints

    @Override
    public List<Asset> getAssets() {
        return executeSync(gateApiService.getAssets());
    }
}
