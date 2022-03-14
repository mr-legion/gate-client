package io.gate.constant;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Constants used throughout Gate's API.
 */
public class GateApiConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "gate.io";

    /**
     * REST API base domain.
     */
    public static final String API_BASE_DOMAIN = "gateio.ws";

    /**Спланувати бюджет на рік
     * Web base URL.
     */
    public static final String WEB_BASE_URL = "https://www." + BASE_DOMAIN;

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://api." + API_BASE_DOMAIN;

    /**
     * Default ToStringStyle used by toString methods.
     */
    public static final ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
