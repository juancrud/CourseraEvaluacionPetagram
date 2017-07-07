package com.juancrud.petagram.db;

import android.content.Context;

import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;

public class DatabaseManager {

    private Context context;

    public DatabaseManager(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> getMascotas() {
        Database db = new Database(context);
        return db.getAll(Constants.TABLE_MASCOTA);
    }

}
