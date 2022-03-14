package io.gate.impl;

import io.gate.domain.general.Asset;
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

}
