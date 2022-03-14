package io.gate.security;

import io.gate.constant.GateApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * API authentication information.
 */
public class ApiCredentials {

    private final String apiKey;
    private final String secret;

    public ApiCredentials(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, GateApiConstants.TO_STRING_BUILDER_STYLE)
                .append("apiKey", apiKey)
                .append("secret", "****")
                .toString();
    }
}
