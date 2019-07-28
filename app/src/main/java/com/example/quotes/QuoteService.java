package com.example.quotes;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Callback;
import okhttp3.Request;

public class QuoteService {
    public static void findQuotes(String id, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.QUOTE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.QUOTE_ID_QUERY_PARAMETER, id);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}
