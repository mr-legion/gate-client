package io.gate.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market description.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    @JsonProperty("id")
    private String symbol;

    /**
     * Base asset symbol.
     */
    @JsonProperty("base")
    private String baseAsset;

    /**
     * Quote asset symbol.
     */
    @JsonProperty("quote")
    private String quoteAsset;

    @JsonProperty("trade_status")
    private MarketStatus status;

    /**
     * Trading fee.
     */
    private Double fee;

    /**
     * Minimum amount of base currency to trade, null means no limit.
     */
    private Double minBaseAmount;

    /**
     * Minimum amount of quote currency to trade, null means no limit.
     */
    private Double minQuoteAmount;

    /**
     * Price scale.
     */
    private Integer precision;

    /**
     * Amount scale.
     */
    private Integer amountPrecision;

    /**
     * Sell start unix timestamp in seconds.
     */
    private Long sellStart;

    /**
     * Buy start unix timestamp in seconds.
     */
    private Long buyStart;

}
