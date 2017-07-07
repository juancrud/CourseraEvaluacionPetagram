package com.juancrud.petagram.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;

public class MascotaDbHelper implements IDatasetReader<Mascota>, IValueParser<Mascota> {

    private DatabaseExecuter dbExecuter;

    public MascotaDbHelper(DatabaseExecuter dbExecuter){
        this.dbExecuter = dbExecuter;
    }

    @Override
    public Mascota read(Cursor dataset, SQLiteDatabase db) {
        Mascota mascota = new Mascota();
        mascota.setId(dataset.getInt(0));
        mascota.setNombre(dataset.getString(1));
        mascota.setImagen(dataset.getInt(2));

        List<Pair<String, String>> filter = new ArrayList<>();
        filter.add(new Pair<>(Constants.FIELD_MASCOTA_LIKES_MASCOTA_ID, ""+mascota.getId()));
        int rating = dbExecuter.getCount(db, Constants.TABLE_MASCOTA_LIKES, filter);
        mascota.setRating(rating);

        return mascota;
    }

    @Override
    public ContentValues parseValues(Mascota mascota) {
        ContentValues result = new ContentValues();
        result.put(Constants.FIELD_MASCOTA_NAME, mascota.getNombre());
        result.put(Constants.FIELD_MASCOTA_IMAGE, mascota.getImagen());
        return result;
    }
}
