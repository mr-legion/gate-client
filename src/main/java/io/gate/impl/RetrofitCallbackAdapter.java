package io.gate.impl;

import io.gate.GateApiError;
import io.gate.exception.GateApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static io.gate.impl.GateApiServiceGenerator.getGateApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                GateApiError apiError = getGateApiError(response);
                onFailure(call, new GateApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new GateApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof GateApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new GateApiException(t));
        }
    }
}
