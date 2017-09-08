package com.juancrud.petagram.restApi.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.juancrud.petagram.restApi.JsonKeys;
import com.juancrud.petagram.restApi.model.SearchUserResponse;

import java.lang.reflect.Type;

public class SearchUserDeserializer implements JsonDeserializer<SearchUserResponse> {

    @Override
    public SearchUserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        SearchUserResponse searchUserResponse = gson.fromJson(json, SearchUserResponse.class);

        JsonArray searchUserData = json.getAsJsonObject().getAsJsonArray(JsonKeys.RESPONSE_DATA);
        if(searchUserData.size() == 0){
            return null;
        }

        JsonObject searchUserDataObj = searchUserData.get(0).getAsJsonObject();
        int id = searchUserDataObj.get(JsonKeys.SEARCH_USER_DATA_ID).getAsInt();
        String userName = searchUserDataObj.get(JsonKeys.SEARCH_USER_DATA_USERNAME).getAsString();
        String fullName = searchUserDataObj.get(JsonKeys.SEARCH_USER_DATA_FULLNAME).getAsString();
        String profileImage = searchUserDataObj.get(JsonKeys.SEARCH_USER_DATA_PROFILE_PICTURE).getAsString();

        searchUserResponse.setId(id);
        searchUserResponse.setUserName(userName);
        searchUserResponse.setFullName(fullName);
        searchUserResponse.setProfileImage(profileImage);

        return searchUserResponse;
    }

}
