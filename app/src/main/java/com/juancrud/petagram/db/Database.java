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

    private Context context;

    public Database(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + Constants.TABLE_MASCOTA_LIKES);
        db.execSQL("DROP TABLE IF EXIST " + Constants.TABLE_MASCOTA);
        onCreate(db);
    }

    public void insert(String tableName, ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(tableName, null, contentValues);
        db.close();
    }

    public ArrayList<Mascota> getAll(String tableName) {
        String qry = "SELECT * FROM " + tableName;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dataset = db.rawQuery(qry, null);
        ArrayList<Mascota> values = readMascotas(dataset);
        db.close();
        return values;
    }

    public int getCount(String tableName, List<Pair<String, String>> filter) {
        String qry = "SELECT COUNT(*) FROM " + tableName;
        if(filter != null){
            for(int i = 0; i <= filter.size(); i++){
                Pair<String, String> pair = filter.get(i);
                qry += i == 0 ? " WHERE " : " AND ";
                qry += pair.first + " = " + pair.second;
            }
        }

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dataset = db.rawQuery(qry, null);

        int count = 0;
        if (dataset.moveToNext()){
            count = dataset.getInt(0);
        }

        db.close();
        return count;
    }

    private ArrayList<Mascota> readMascotas(Cursor dataset) {
        ArrayList<Mascota> values = new ArrayList<>();
        while(dataset.moveToNext()) {
            Mascota mascota = new Mascota();
            mascota.setId(dataset.getInt(0));
            mascota.setNombre(dataset.getString(1));
            mascota.setImagen(dataset.getInt(2));
            values.add(mascota);
        }
        return values;
    }

}
