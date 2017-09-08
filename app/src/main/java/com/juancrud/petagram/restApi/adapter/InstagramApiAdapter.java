package com.juancrud.petagram.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.juancrud.petagram.restApi.Constants;
import com.juancrud.petagram.restApi.InstagramApi;
import com.juancrud.petagram.restApi.deserializer.RecentMediaDeserializer;
import com.juancrud.petagram.restApi.deserializer.SearchUserDeserializer;
import com.juancrud.petagram.restApi.model.RecentMediaResponse;
import com.juancrud.petagram.restApi.model.SearchUserResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstagramApiAdapter {

    public InstagramApi getApiConnection(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(InstagramApi.class);
    }

    public Gson buildSearchUserResponseDeserializer(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SearchUserResponse.class, new SearchUserDeserializer());
        return gsonBuilder.create();
    }

    public Gson buildRecentMediaResponseDeserializer(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(RecentMediaResponse.class, new RecentMediaDeserializer());
        return gsonBuilder.create();
    }
}
