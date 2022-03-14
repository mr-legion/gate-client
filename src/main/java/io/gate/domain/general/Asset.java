package io.gate.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.gate.constant.GateApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An asset.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("currency")
    private String symbol;

    private boolean delisted;

    @JsonProperty("trade_disabled")
    private boolean tradeDisabled;

    @JsonProperty("deposit_disabled")
    private boolean depositDisabled;

    @JsonProperty("withdraw_disabled")
    private boolean withdrawDisabled;

    @JsonProperty("withdraw_delayed")
    private boolean withdrawDelayed;

    public Asset() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isDelisted() {
        return delisted;
    }

    public void setDelisted(boolean delisted) {
        this.delisted = delisted;
    }

    public boolean isTradeDisabled() {
        return tradeDisabled;
    }

    public void setTradeDisabled(boolean tradeDisabled) {
        this.tradeDisabled = tradeDisabled;
    }

    public boolean isDepositDisabled() {
        return depositDisabled;
    }

    public void setDepositDisabled(boolean depositDisabled) {
        this.depositDisabled = depositDisabled;
    }

    public boolean isWithdrawDisabled() {
        return withdrawDisabled;
    }

    public void setWithdrawDisabled(boolean withdrawDisabled) {
        this.withdrawDisabled = withdrawDisabled;
    }

    public boolean isWithdrawDelayed() {
        return withdrawDelayed;
    }

    public void setWithdrawDelayed(boolean withdrawDelayed) {
        this.withdrawDelayed = withdrawDelayed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, GateApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("delisted", delisted)
                .append("tradeDisabled", tradeDisabled)
                .append("depositDisabled", depositDisabled)
                .append("withdrawDisabled", withdrawDisabled)
                .append("withdrawDelayed", withdrawDelayed)
                .toString();
    }
}