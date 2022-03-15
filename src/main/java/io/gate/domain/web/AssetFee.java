package io.gate.domain.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Asset fee information.
 */
@Getter
@EqualsAndHashCode
@ToString
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
}
