package com.juancrud.petagram.restApi.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.juancrud.petagram.pojo.Foto;
import com.juancrud.petagram.restApi.JsonKeys;
import com.juancrud.petagram.restApi.model.RecentMediaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class RecentMediaDeserializer implements JsonDeserializer<RecentMediaResponse>  {
    @Override
    public RecentMediaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        RecentMediaResponse recentMediaResponse = gson.fromJson(json, RecentMediaResponse.class);

        JsonArray recentMediaData = json.getAsJsonObject().getAsJsonArray(JsonKeys.RESPONSE_DATA);
        recentMediaResponse.setFotos(deserializeRecentMedia(recentMediaData));

        return recentMediaResponse;
    }

    private ArrayList<Foto> deserializeRecentMedia(JsonArray recentMediaData){
        ArrayList<Foto> fotos = new ArrayList<>();

        for (int i = 0; i < recentMediaData.size(); i++) {
            JsonObject recentMediaDataObject = recentMediaData.get(i).getAsJsonObject();

            JsonObject imageJson = recentMediaDataObject.getAsJsonObject(JsonKeys.RECENT_MEDIA_DATA_IMAGES);
            JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.RECENT_MEDIA_DATA_IMAGES_STD);
            String imagenUrl = stdResolutionJson.get(JsonKeys.RECENT_MEDIA_DATA_IMAGES_STD_URL).getAsString();

            JsonObject likesJson = recentMediaDataObject.getAsJsonObject(JsonKeys.RECENT_MEDIA_DATA_LIKES);
            int likes = likesJson.get(JsonKeys.RECENT_MEDIA_DATA_LIKES_COUNT).getAsInt();

            Foto foto = new Foto();
            foto.setImagenUrl(imagenUrl);
            foto.setRating(likes);
            fotos.add(foto);
        }

        return fotos;
    }
}
