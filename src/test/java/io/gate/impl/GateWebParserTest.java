package io.gate.impl;

import io.gate.domain.web.AssetFee;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GateWebParserTest {

    private final GateWebParser gateWebParser = new GateWebParser(new OkHttpClient());

    @Test
    public void parseAssetFees_ShouldReturnAssetFees() {
        List<AssetFee> assetFees = gateWebParser.parseAssetFees();
        assertThat(assetFees, is(not(empty())));
    }
}