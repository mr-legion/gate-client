package io.gate.security;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.time.Instant;

import static io.gate.constant.GateApiConstants.*;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

    private final ApiCredentials apiCredentials;

    public AuthenticationInterceptor(ApiCredentials apiCredentials) {
        this.apiCredentials = apiCredentials;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        boolean isAuthorizationRequired = original.header(AUTHORIZATION_REQUIRED) != null;
        newRequestBuilder.removeHeader(AUTHORIZATION_REQUIRED);

        // Endpoint requires authorization
        if (isAuthorizationRequired) {

            final String timestamp = Long.toString(Instant.now().getEpochSecond());

            String payload = original.method() + "\n" +
                    original.url().encodedPath() + "\n" +
                    (original.url().encodedQuery() != null ? original.url().encodedQuery() : "") + "\n" +
                    DigestUtils.sha512Hex(bodyToString(original.body())) + "\n" +
                    timestamp;

            String signature = HmacSHA512Signer.signEncodedInHexString(payload, apiCredentials.getSecret());
            newRequestBuilder.addHeader(API_KEY_HEADER, apiCredentials.getApiKey());
            newRequestBuilder.addHeader(SIGN_HEADER, signature);
            newRequestBuilder.addHeader(TIMESTAMP_HEADER, timestamp);
            newRequestBuilder.tag(String.class, apiCredentials.getApiKey());
        }

        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
     */
    private static String bodyToString(RequestBody request) {
        try (final Buffer buffer = new Buffer()) {
            if (request != null) {
                request.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}