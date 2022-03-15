package io.gate.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    @JsonProperty("currency_pair")
    private String symbol;

    private Double last;

    @JsonProperty("lowest_ask")
    private Double ask;

    @JsonProperty("highest_bid")
    private Double bid;

    @JsonProperty("change_percentage")
    private Double changePercentage;

    @JsonProperty("base_volume")
    private Double baseVolume;

    @JsonProperty("quote_volume")
    private Double quoteVolume;

    @JsonProperty("high_24h")
    private Double high24h;

    @JsonProperty("low_24h")
    private Double low24h;

    /**
     * ETF net value.
     */
    @JsonProperty("etf_net_value")
    private Double etfNetValue;

    /**
     * ETF previous net value at re-balancing time.
     */
    @JsonProperty("etf_pre_net_value")
    private Double etfPreNetValue;

    /**
     * ETF previous re-balancing time.
     */
    @JsonProperty("etf_pre_timestamp")
    private Long etfPreTimestamp;

    /**
     * ETF current leverage.
     */
    @JsonProperty("etf_leverage")
    private Double etfLeverage;

}
