package com.juancrud.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private DatabaseExecuter dbExecuter;
    private MascotaDbHelper mascotaHelper;
    private MascotaLikeDbHelper mascotaLikeHelper;

    public DatabaseManager(Context context) {
        dbExecuter = new DatabaseExecuter(context);
        mascotaHelper = new MascotaDbHelper(dbExecuter);
        mascotaLikeHelper = new MascotaLikeDbHelper();
    }

    public ArrayList<Mascota> getMascotas() {
        SQLiteDatabase dbConnection = dbExecuter.getConnection();
        ArrayList<Mascota> mascotas = dbExecuter.getAll(dbConnection, Constants.TABLE_MASCOTA, mascotaHelper);
        dbConnection.close();
        return mascotas;
    }

    public ArrayList<Mascota> getUltimos5Likes() {
        SQLiteDatabase dbConnection = dbExecuter.getConnection();
        ArrayList<Mascota> mascotas = dbExecuter.getUltimosLikes(dbConnection, Constants.QUERY_ULTIMAS_5_MASCOTAS, mascotaHelper);
        dbConnection.close();
        return mascotas;
    }

    public void insertLike(Mascota mascota) {
        SQLiteDatabase dbConnection = dbExecuter.getConnection();
        ContentValues values = mascotaLikeHelper.parseValues(mascota.getId());
        dbExecuter.insert(dbConnection, Constants.TABLE_MASCOTA_LIKES, values);
        dbConnection.close();
    }

    public int getLikes(Mascota mascota) {
        SQLiteDatabase dbConnection = dbExecuter.getConnection();

        List<Pair<String, String>> filter = new ArrayList<>();
        filter.add(new Pair<>(Constants.FIELD_MASCOTA_LIKES_MASCOTA_ID, ""+mascota.getId()));
        int likes = dbExecuter.getCount(dbConnection, Constants.TABLE_MASCOTA_LIKES, filter);

        dbConnection.close();
        return likes;
    }
}
