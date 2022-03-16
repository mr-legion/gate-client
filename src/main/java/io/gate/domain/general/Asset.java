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

    private Boolean delisted;

    @JsonProperty("trade_disabled")
    private Boolean tradeDisabled;

    @JsonProperty("deposit_disabled")
    private Boolean depositDisabled;

    @JsonProperty("withdraw_disabled")
    private Boolean withdrawDisabled;

    @JsonProperty("withdraw_delayed")
    private Boolean withdrawDelayed;

}