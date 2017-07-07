package com.juancrud.petagram.db;

import android.content.ContentValues;

import java.util.Date;

public class MascotaLikeDbHelper implements IValueParser<Integer> {

    @Override
    public ContentValues parseValues(Integer idMascota) {
        ContentValues result = new ContentValues();
        result.put(Constants.FIELD_MASCOTA_LIKES_MASCOTA_ID, idMascota);
        result.put(Constants.FIELD_MASCOTA_LIKES_FECHA, new Date().getTime());
        return result;
    }
}
