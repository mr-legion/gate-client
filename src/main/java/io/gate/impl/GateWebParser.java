package io.gate.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gate.domain.web.AssetFee;
import io.gate.exception.GateWebParsingException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.gate.constant.GateApiConstants.WEB_BASE_URL;

/**
 * This class is used to parse Gate web pages.
 */
public class GateWebParser {

    private static final String FEE_PATH = "/fee";

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final OkHttpClient okHttpClient;

    public GateWebParser(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public List<AssetFee> parseAssetFees() {
        try {
            Request request = new Request.Builder()
                    .url(WEB_BASE_URL + FEE_PATH)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String page = response.body().string();

            String varName = "const withdraw_feelist = ";
            String feesJson = page.substring(page.indexOf(varName) + varName.length());
            feesJson = feesJson.substring(0, feesJson.indexOf(";"));

            TypeReference<Map<String, AssetFee>> type = new TypeReference<Map<String, AssetFee>>() {};
            Map<String, AssetFee> feeByAsset = objectMapper.readValue(feesJson, type);

            return new ArrayList<>(feeByAsset.values());
        } catch (Exception e) {
            throw new GateWebParsingException("failed to parse asset fees", e);
        }
    }
}
