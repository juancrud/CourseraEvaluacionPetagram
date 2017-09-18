package com.juancrud.petagram.restApi.model;

import com.juancrud.petagram.pojo.UserProfile;

public class SearchUserResponse {

    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
