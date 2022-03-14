package io.gate.impl;

import io.gate.GateApiClientFactory;
import io.gate.GateApiRestClient;
import io.gate.domain.general.Asset;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GateApiRestClientImplTest {

    private final GateApiRestClient gateApiRestClient = GateApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        List<Asset> assets = gateApiRestClient.getAssets();
        assertThat(assets, is(not(empty())));
    }
}