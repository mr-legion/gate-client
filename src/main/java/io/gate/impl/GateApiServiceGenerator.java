package io.gate.impl;

import io.gate.GateApiError;
import io.gate.exception.GateApiException;
import io.gate.security.ApiCredentials;
import io.gate.security.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static io.gate.constant.GateApiConstants.API_BASE_URL;

/**
 * Generates a Gate API implementation based on @see {@link GateApiService}.
 */
public class GateApiServiceGenerator {

    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, GateApiError> errorBodyConverter =
            (Converter<ResponseBody, GateApiError>) converterFactory.responseBodyConverter(
                    GateApiError.class, new Annotation[0], null);

    private final OkHttpClient client;

    public GateApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    public <S> S createService(Class<S> serviceClass, ApiCredentials apiCredentials) {

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(converterFactory);

        if (apiCredentials == null) {
            retrofitBuilder.client(client);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor authInterceptor = new AuthenticationInterceptor(apiCredentials);
            OkHttpClient.Builder newBuilder = client.newBuilder();
            newBuilder.interceptors().add(0, authInterceptor);
            OkHttpClient adaptedClient = newBuilder.build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                GateApiError apiError = getGateApiError(response);
                throw new GateApiException(apiError);
            }
        } catch (IOException e) {
            throw new GateApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static GateApiError getGateApiError(Response<?> response) throws IOException, GateApiException {
        return errorBodyConverter.convert(response.errorBody());
    }
}
