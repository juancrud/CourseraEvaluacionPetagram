package com.juancrud.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;

public class DatabaseManager {

    private DatabaseExecuter dbExecuter;
    private MascotaDbHelper mascotaHelper;

    public DatabaseManager(Context context) {
        dbExecuter = new DatabaseExecuter(context);
        mascotaHelper = new MascotaDbHelper();
    }

    public ArrayList<Mascota> getMascotas() {
        SQLiteDatabase dbConnection = dbExecuter.getConnection();
        ArrayList<Mascota> mascotas = dbExecuter.getAll(dbConnection, Constants.TABLE_MASCOTA, mascotaHelper);
        dbConnection.close();
        return mascotas;
    }

    public void insertMascotas(ArrayList<Mascota> mascotas) {
        SQLiteDatabase dbConnection = dbExecuter.getConnection();
        for(Mascota mascota : mascotas) {
            ContentValues values = mascotaHelper.parseValues(mascota);
            dbExecuter.insert(dbConnection, Constants.TABLE_MASCOTA, values);
        }
        dbConnection.close();
    }

}
