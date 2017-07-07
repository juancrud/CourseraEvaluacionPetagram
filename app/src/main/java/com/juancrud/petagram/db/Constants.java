package com.juancrud.petagram.db;

public class Constants {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTA = "mascota";
    public static final String TABLE_MASCOTA_LIKES = "mascota_likes";

    public static final String FIELD_MASCOTA_ID = "id";
    public static final String FIELD_MASCOTA_NAME = "nombre";
    public static final String FIELD_MASCOTA_IMAGE = "imagen";

    public static final String FIELD_MASCOTA_LIKES_ID = "id";
    public static final String FIELD_MASCOTA_LIKES_MASCOTA_ID = "mascota_id";
    public static final String FIELD_MASCOTA_LIKES_FECHA = "fecha";

}
