package com.juancrud.petagram.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.juancrud.petagram.pojo.Mascota;

public class MascotaDbHelper implements IDatasetReader<Mascota>, IValueParser<Mascota> {

    @Override
    public Mascota read(Cursor dataset) {
        Mascota mascota = new Mascota();
        mascota.setId(dataset.getInt(0));
        mascota.setNombre(dataset.getString(1));
        mascota.setImagen(dataset.getInt(2));
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
