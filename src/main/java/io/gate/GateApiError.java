package io.gate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.gate.constant.GateApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Gate API error.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GateApiError {

    @JsonProperty("message")
    private String msg;

    public GateApiError() {
    }

    public GateApiError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, GateApiConstants.TO_STRING_BUILDER_STYLE)
                .append("msg", msg)
                .toString();
    }
}
