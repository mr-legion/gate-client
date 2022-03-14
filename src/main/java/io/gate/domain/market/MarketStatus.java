package io.gate.domain.market;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market status.
 */
public enum MarketStatus {
    @JsonProperty("tradable")
    TRADABLE,

    @JsonProperty("untradable")
    UNTRADABLE,

    @JsonProperty("sellable")
    SELLABLE,

    @JsonProperty("buyable")
    BUYABLE
}
