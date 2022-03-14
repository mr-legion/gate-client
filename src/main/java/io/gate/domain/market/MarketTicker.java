package io.gate.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.gate.constant.GateApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Market ticker information.
 */
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

    public MarketTicker() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(Double changePercentage) {
        this.changePercentage = changePercentage;
    }

    public Double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(Double baseVolume) {
        this.baseVolume = baseVolume;
    }

    public Double getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(Double quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public Double getHigh24h() {
        return high24h;
    }

    public void setHigh24h(Double high24h) {
        this.high24h = high24h;
    }

    public Double getLow24h() {
        return low24h;
    }

    public void setLow24h(Double low24h) {
        this.low24h = low24h;
    }

    public Double getEtfNetValue() {
        return etfNetValue;
    }

    public void setEtfNetValue(Double etfNetValue) {
        this.etfNetValue = etfNetValue;
    }

    public Double getEtfPreNetValue() {
        return etfPreNetValue;
    }

    public void setEtfPreNetValue(Double etfPreNetValue) {
        this.etfPreNetValue = etfPreNetValue;
    }

    public Long getEtfPreTimestamp() {
        return etfPreTimestamp;
    }

    public void setEtfPreTimestamp(Long etfPreTimestamp) {
        this.etfPreTimestamp = etfPreTimestamp;
    }

    public Double getEtfLeverage() {
        return etfLeverage;
    }

    public void setEtfLeverage(Double etfLeverage) {
        this.etfLeverage = etfLeverage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, GateApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("last", last)
                .append("ask", ask)
                .append("bid", bid)
                .append("changePercentage", changePercentage)
                .append("baseVolume", baseVolume)
                .append("quoteVolume", quoteVolume)
                .append("high24h", high24h)
                .append("low24h", low24h)
                .append("etfNetValue", etfNetValue)
                .append("etfPreNetValue", etfPreNetValue)
                .append("etfPreTimestamp", etfPreTimestamp)
                .append("etfLeverage", etfLeverage)
                .toString();
    }
}
