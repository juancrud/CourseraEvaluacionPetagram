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
        return dbExecuter.getAll(Constants.TABLE_MASCOTA, mascotaHelper);
    }

    public ArrayList<Mascota> getUltimos5Likes() {
        return dbExecuter.getUltimosLikes(Constants.QUERY_ULTIMAS_5_MASCOTAS, mascotaHelper);
    }

    public void insertLike(Mascota mascota) {
        ContentValues values = mascotaLikeHelper.parseValues(mascota.getId());
        dbExecuter.insert(Constants.TABLE_MASCOTA_LIKES, values);
    }

    public int getLikes(Mascota mascota) {
        List<Pair<String, String>> filter = new ArrayList<>();
        filter.add(new Pair<>(Constants.FIELD_MASCOTA_LIKES_MASCOTA_ID, ""+mascota.getId()));
        return dbExecuter.getCount(Constants.TABLE_MASCOTA_LIKES, filter);
    }
}
