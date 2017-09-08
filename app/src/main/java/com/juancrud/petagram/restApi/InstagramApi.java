package com.juancrud.petagram.restApi;

import com.juancrud.petagram.restApi.model.RecentMediaResponse;
import com.juancrud.petagram.restApi.model.SearchUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InstagramApi {

    @GET(Constants.URL_SEARCH_USER)
    Call<SearchUserResponse> searchUser(@Path(Constants.PARAM_QUERY) String userName);

    @GET(Constants.URL_GET_RECENT_MEDIA_USER)
    Call<RecentMediaResponse> getRecentMedia(@Path(Constants.PARAM_USER_ID) long userId);

}
