package io.gate.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.gate.constant.GateApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Market orderbook.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook {

    /**
     * Order book ID, which is updated whenever the order book is changed.
     */
    private Long id;

    /**
     * The timestamp of the response data being generated (in milliseconds).
     */
    private long current;

    /**
     * The timestamp of when the orderbook last changed (in milliseconds).
     */
    private long update;

    private List<Order> asks;
    private List<Order> bids;

    public OrderBook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getUpdate() {
        return update;
    }

    public void setUpdate(long update) {
        this.update = update;
    }

    public List<Order> getAsks() {
        return asks;
    }

    public void setAsks(List<Order> asks) {
        this.asks = asks;
    }

    public List<Order> getBids() {
        return bids;
    }

    public void setBids(List<Order> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, GateApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("current", current)
                .append("update", update)
                .append("asks", asks)
                .append("bids", bids)
                .toString();
    }
}
