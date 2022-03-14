package io.gate.domain.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.gate.constant.GateApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Asset fee information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetFee {

    /**
     * Asset symbol.
     */
    private final String symbol;

    private final String network;

    private final Double fixedWithdrawFee;
    private final Double ratioWithdrawFee;

    @JsonCreator
    public AssetFee(@JsonProperty("symbol") String symbolAndNetwork,
                    @JsonProperty("withdraw_fix") Double fixedWithdrawalFee,
                    @JsonProperty("withdraw_percent") String ratioWithdrawalFee) {
        String[] symbolAndNetworkArr = symbolAndNetwork.split("_");
        if (symbolAndNetworkArr.length == 2) {
            this.symbol = symbolAndNetworkArr[0];
            this.network = symbolAndNetworkArr[1];
        } else {
            this.symbol = symbolAndNetworkArr[0];
            this.network = "";
        }
        this.fixedWithdrawFee = fixedWithdrawalFee;
        this.ratioWithdrawFee = Double.parseDouble(ratioWithdrawalFee.replace("%", ""));
    }

    public String getSymbol() {
        return symbol;
    }

    public String getNetwork() {
        return network;
    }

    public Double getFixedWithdrawFee() {
        return fixedWithdrawFee;
    }

    public Double getRatioWithdrawFee() {
        return ratioWithdrawFee;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, GateApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("network", network)
                .append("fixedWithdrawFee", fixedWithdrawFee)
                .append("ratioWithdrawFee", ratioWithdrawFee)
                .toString();
    }
}
