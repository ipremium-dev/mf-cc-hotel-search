package com.mf.hotel.search.service;

import com.mf.hotel.search.YamlAppProperties;
import com.mf.hotel.search.auth.TokenInterceptor;
import com.mf.hotel.search.intf.ApiSvcI;
import com.mf.hotel.search.model.SearchParam;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ApiSvc implements ApiSvcI {

    @Autowired
    private YamlAppProperties yamlAppProperties;

    @Override
    public String callGet(SearchParam searchParam, String uuid) {

        String responseString = null;

        HttpUrl.Builder urlBuilder = HttpUrl.parse(yamlAppProperties.getSearchApi()).newBuilder();
        urlBuilder.addQueryParameter("keyword",searchParam.getKeyword());
        urlBuilder.addQueryParameter("checkin",searchParam.getCheckin());
        urlBuilder.addQueryParameter("checkout",searchParam.getCheckout());
        urlBuilder.addQueryParameter("number",String.valueOf(searchParam.getNumber()));

        String apiWParam = urlBuilder.build().toString();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor(uuid))
                .build();

        Request request = new Request.Builder()
                .url(apiWParam)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()){
            System.out.println("http status code: "+response.code());

             responseString = response.body().string();

        }catch (IOException e){
            e.printStackTrace();
        }

        return responseString;
    }
}
