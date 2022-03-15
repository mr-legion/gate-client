package io.gate.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Market orderbook.
 */
@NoArgsConstructor
@Data
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

}
