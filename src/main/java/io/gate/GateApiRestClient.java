package io.gate;

import io.gate.domain.general.Asset;

import java.util.List;

/**
 * Gate API facade, supporting synchronous/blocking access Gate's REST API.
 */
public interface GateApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    List<Asset> getAssets();

}