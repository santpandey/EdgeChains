package com.edgechain.lib.endpoint.impl;

import com.edgechain.lib.endpoint.Endpoint;
import com.edgechain.lib.retrofit.WikiService;
import com.edgechain.lib.retrofit.client.RetrofitClientInstance;
import com.edgechain.lib.rxjava.retry.RetryPolicy;
import com.edgechain.lib.wiki.request.WikiRequest;
import com.edgechain.lib.wiki.response.WikiResponse;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;

public class WikiEndpoint extends Endpoint {

    private final Retrofit retrofit = RetrofitClientInstance.getInstance();
    private final WikiService wikiService = retrofit.create(WikiService.class);


    public WikiEndpoint() {}

    public WikiEndpoint(RetryPolicy retryPolicy) {
        super(retryPolicy);
    }

    public Observable<WikiResponse> getPageContent(String query) {
        return Observable.fromSingle(wikiService.getPageContent(new WikiRequest(this, query)));
    }
}
