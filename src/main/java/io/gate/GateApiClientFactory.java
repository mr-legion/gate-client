package io.gate;

import io.gate.impl.GateApiAsyncRestClientImpl;
import io.gate.impl.GateApiRestClientImpl;
import io.gate.impl.GateApiService;
import io.gate.impl.GateApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Gate API client objects.
 */
public class GateApiClientFactory {

    private final GateApiServiceGenerator serviceGenerator;

    public GateApiClientFactory() {
        this(new OkHttpClient());
    }

    private GateApiClientFactory(OkHttpClient client) {
        this.serviceGenerator = new GateApiServiceGenerator(client);
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
     * Creates a new synchronous/blocking REST client.
     */
    public GateApiRestClient newRestClient() {
        return new GateApiRestClientImpl(serviceGenerator.createService(GateApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public GateApiAsyncRestClient newAsyncRestClient() {
        return new GateApiAsyncRestClientImpl(serviceGenerator.createService(GateApiService.class));
    }
}
