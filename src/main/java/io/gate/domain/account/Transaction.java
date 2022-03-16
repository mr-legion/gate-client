package io.gate.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.gate.domain.TimestampDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Transaction information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private String id;

    /**
     * Asset symbol
     */
    @JsonProperty("currency")
    private String asset;

    @JsonProperty("amount")
    private Double quantity;

    private String address;
    private String memo;
    private String chain;

    private String txid;

    private TransactionStatus status;

    @JsonProperty("timestamp")
    @JsonDeserialize(using = TimestampDeserializer.class)
    private LocalDateTime dateTime;

}