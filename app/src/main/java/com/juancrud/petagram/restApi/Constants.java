package com.juancrud.petagram.restApi;

public final class Constants {
    private static final String VERSION = "/v1/";
    private static final String ACCESS_TOKEN = "5713483640.e4cb995.9bd923cc6a6a450785fd11a9fd6e6995";
    private static final String KEY_ACCESS_TOKEN = "?access_token=";
    private static final String KEY_Q = "&q=";

    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String PARAM_Q = "q";
    public static final String PARAM_USER_ID = "user-id";

    private static final String KEY_SEARCH_USER = "users/search";
    private static final String KEY_GET_RECENT_MEDIA_USER = "users/{" + PARAM_USER_ID + "}/media/recent";

    //users/search?access_token=5713483640.e4cb995.9bd923cc6a6a450785fd11a9fd6e6995
    public static final String URL_SEARCH_USER = KEY_SEARCH_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //users/{user-id}/media/recent?access_token=5713483640.e4cb995.9bd923cc6a6a450785fd11a9fd6e6995
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

}
