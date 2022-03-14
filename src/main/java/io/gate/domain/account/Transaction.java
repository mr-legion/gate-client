package io.gate.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.gate.constant.GateApiConstants;
import io.gate.domain.TimestampDeserializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

/**
 * Transaction information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private String id;

    /**
     * Asset symbol
     */
    @JsonProperty("currency")
    private String asset;

    @JsonProperty("amount")
    private double quantity;

    private String address;
    private String memo;
    private String chain;

    private String txid;

    private TransactionStatus status;

    @JsonProperty("timestamp")
    @JsonDeserialize(using = TimestampDeserializer.class)
    private LocalDateTime dateTime;

    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, GateApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("asset", asset)
                .append("quantity", quantity)
                .append("address", address)
                .append("memo", memo)
                .append("chain", chain)
                .append("txid", txid)
                .append("status", status)
                .append("dateTime", dateTime)
                .toString();
    }
}