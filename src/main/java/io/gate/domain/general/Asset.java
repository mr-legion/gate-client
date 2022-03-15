package io.gate.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An asset.
 */
@NoArgsConstructor
@Data
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

}