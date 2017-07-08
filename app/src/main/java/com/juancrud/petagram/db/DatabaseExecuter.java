package com.juancrud.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DatabaseExecuter {

    private Database database;

    public DatabaseExecuter(Context context) {
        database = new Database(context);
    }

    public void insert(String tableName, ContentValues contentValues) {
        SQLiteDatabase db = database.getWritableDatabase();
        db.insert(tableName, null, contentValues);
        db.close();
    }

    public <T> ArrayList<T> getAll(String tableName, IDatasetReader<T> reader) {
        SQLiteDatabase db = database.getWritableDatabase();
        String qry = "SELECT * FROM " + tableName;
        Cursor dataset = db.rawQuery(qry, null);

        ArrayList<T> values = new ArrayList<>();
        while(dataset.moveToNext()) {
            values.add(reader.read(dataset, db));
        }

        db.close();
        return values;
    }

    public <T> ArrayList<T> getUltimosLikes(String qry, IDatasetReader<T> reader) {
        SQLiteDatabase db = database.getWritableDatabase();
        Cursor dataset = db.rawQuery(qry, null);

        ArrayList<T> values = new ArrayList<>();
        while(dataset.moveToNext()) {
            values.add(reader.read(dataset, db));
        }

        db.close();
        return values;
    }

    public int getCount(String tableName, List<Pair<String, String>> filter) {
        String qry = "SELECT COUNT(*) FROM " + tableName;
        if(filter != null){
            for(int i = 0; i < filter.size(); i++){
                Pair<String, String> pair = filter.get(i);
                qry += i == 0 ? " WHERE " : " AND ";
                qry += pair.first + " = " + pair.second;
            }
        }

        SQLiteDatabase db = database.getWritableDatabase();
        Cursor dataset = db.rawQuery(qry, null);
        int count = 0;
        if (dataset.moveToNext()){
            count = dataset.getInt(0);
        }

        db.close();
        return count;
    }
}
