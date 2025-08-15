package com.mf.hotel.search.auth;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class TokenInterceptor implements Interceptor{

    private final String uuidToken;

    public TokenInterceptor(String uuidToken){
        this.uuidToken = uuidToken;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        Request newRequest = request.newBuilder()
                .addHeader("X-ACCESS-TOKEN",uuidToken)
                .build();

        return chain.proceed(newRequest);
    }
}
