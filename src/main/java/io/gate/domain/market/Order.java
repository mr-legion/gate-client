package io.gate.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.gate.constant.GateApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An order.
 */
@JsonDeserialize(using = OrderDeserializer.class)
@JsonSerialize(using = OrderSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    private double price;
    private double quantity;

    public Order() {
    }

    public Order(double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, GateApiConstants.TO_STRING_BUILDER_STYLE)
                .append("price", price)
                .append("quantity", quantity)
                .toString();
    }
}
