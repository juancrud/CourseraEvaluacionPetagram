package com.juancrud.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qryMascota = "CREATE TABLE " + Constants.TABLE_MASCOTA + "(" +
                Constants.FIELD_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constants.FIELD_MASCOTA_NAME + " TEXT, " +
                Constants.FIELD_MASCOTA_IMAGE + " INTEGER " +
            ")";

        String qryMascotaLikes =  "CREATE TABLE " + Constants.TABLE_MASCOTA_LIKES + "(" +
                Constants.FIELD_MASCOTA_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constants.FIELD_MASCOTA_LIKES_MASCOTA_ID + " INTEGER, " +
                Constants.FIELD_MASCOTA_LIKES_FECHA + " TEXT, " +
                "FOREIGN KEY (" + Constants.FIELD_MASCOTA_LIKES_MASCOTA_ID + ") " +
                "REFERENCES " + Constants.TABLE_MASCOTA + "(" + Constants.FIELD_MASCOTA_ID + ")" +
            ")";

        db.execSQL(qryMascota);
        db.execSQL(qryMascotaLikes);

        //SeedData
        MascotaDbHelper mascotaHelper = new MascotaDbHelper();
        for(Mascota mascota : SeedData.Mascotas) {
            ContentValues values = mascotaHelper.parseValues(mascota);
            db.insert(Constants.TABLE_MASCOTA, null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + Constants.TABLE_MASCOTA_LIKES);
        db.execSQL("DROP TABLE IF EXIST " + Constants.TABLE_MASCOTA);
        onCreate(db);
    }

}
