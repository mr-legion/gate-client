package io.gate.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.gate.constant.GateApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Market description.
 */
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
    private int precision;

    /**
     * Amount scale.
     */
    private int amountPrecision;

    /**
     * Sell start unix timestamp in seconds.
     */
    private long sellStart;

    /**
     * Buy start unix timestamp in seconds.
     */
    private long buyStart;

    public MarketInfo() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public MarketStatus getStatus() {
        return status;
    }

    public void setStatus(MarketStatus status) {
        this.status = status;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getMinBaseAmount() {
        return minBaseAmount;
    }

    public void setMinBaseAmount(Double minBaseAmount) {
        this.minBaseAmount = minBaseAmount;
    }

    public Double getMinQuoteAmount() {
        return minQuoteAmount;
    }

    public void setMinQuoteAmount(Double minQuoteAmount) {
        this.minQuoteAmount = minQuoteAmount;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getAmountPrecision() {
        return amountPrecision;
    }

    public void setAmountPrecision(int amountPrecision) {
        this.amountPrecision = amountPrecision;
    }

    public long getSellStart() {
        return sellStart;
    }

    public void setSellStart(long sellStart) {
        this.sellStart = sellStart;
    }

    public long getBuyStart() {
        return buyStart;
    }

    public void setBuyStart(long buyStart) {
        this.buyStart = buyStart;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, GateApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("baseAsset", baseAsset)
                .append("quoteAsset", quoteAsset)
                .append("status", status)
                .append("fee", fee)
                .append("minBaseAmount", minBaseAmount)
                .append("minQuoteAmount", minQuoteAmount)
                .append("precision", precision)
                .append("amountPrecision", amountPrecision)
                .append("sellStart", sellStart)
                .append("buyStart", buyStart)
                .toString();
    }
}
