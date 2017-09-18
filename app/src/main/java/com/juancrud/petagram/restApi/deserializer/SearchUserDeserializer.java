package com.juancrud.petagram.restApi.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.juancrud.petagram.pojo.Foto;
import com.juancrud.petagram.pojo.UserProfile;
import com.juancrud.petagram.restApi.JsonKeys;
import com.juancrud.petagram.restApi.model.SearchUserResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SearchUserDeserializer implements JsonDeserializer<SearchUserResponse> {

    @Override
    public SearchUserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        SearchUserResponse searchUserResponse = gson.fromJson(json, SearchUserResponse.class);

        JsonArray searchUserData = json.getAsJsonObject().getAsJsonArray(JsonKeys.RESPONSE_DATA);
        searchUserResponse.setUserProfile(deserializeSearchUser(searchUserData));
        return searchUserResponse;
    }

    private UserProfile deserializeSearchUser(JsonArray searchUserData) {
        if(searchUserData.size() == 0){
            return null;
        }

        JsonObject searchUserDataObj = searchUserData.get(0).getAsJsonObject();
        long id = searchUserDataObj.get(JsonKeys.SEARCH_USER_DATA_ID).getAsLong();
        String userName = searchUserDataObj.get(JsonKeys.SEARCH_USER_DATA_USERNAME).getAsString();
        String fullName = searchUserDataObj.get(JsonKeys.SEARCH_USER_DATA_FULLNAME).getAsString();
        String profileImage = searchUserDataObj.get(JsonKeys.SEARCH_USER_DATA_PROFILE_PICTURE).getAsString();

        UserProfile userProfile = new UserProfile();
        userProfile.setId(id);
        userProfile.setUserName(userName);
        userProfile.setFullName(fullName);
        userProfile.setProfileImage(profileImage);

        return userProfile;
    }

}
