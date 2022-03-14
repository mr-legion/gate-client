package io.gate;

import io.gate.impl.GateApiAsyncRestClientImpl;
import io.gate.impl.GateApiRestClientImpl;
import io.gate.impl.GateApiService;
import io.gate.impl.GateApiServiceGenerator;
import io.gate.security.ApiCredentials;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Gate API client objects.
 */
public class GateApiClientFactory {

    private final GateApiServiceGenerator serviceGenerator;

    private final ApiCredentials apiCredentials;

    public GateApiClientFactory() {
        this(new OkHttpClient(), null);
    }

    public GateApiClientFactory(ApiCredentials apiCredentials) {
        this(new OkHttpClient(), apiCredentials);
    }

    private GateApiClientFactory(OkHttpClient client, ApiCredentials apiCredentials) {
        this.serviceGenerator = new GateApiServiceGenerator(client);
        this.apiCredentials = apiCredentials;
    }

    /**
     * New instance without authentication.
     *
     * @return the Gate API client factory
     */
    public static GateApiClientFactory newInstance() {
        return new GateApiClientFactory();
    }

    /**
     * New instance with authentication.
     *
     * @return the Gate API client factory
     */
    public static GateApiClientFactory newInstance(ApiCredentials apiCredentials) {
        return new GateApiClientFactory(apiCredentials);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public GateApiRestClient newRestClient() {
        return new GateApiRestClientImpl(serviceGenerator.createService(GateApiService.class, apiCredentials));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public GateApiAsyncRestClient newAsyncRestClient() {
        return new GateApiAsyncRestClientImpl(serviceGenerator.createService(GateApiService.class, apiCredentials));
    }
}
