package com.juancrud.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DatabaseExecuter {

    private Database db;

    public DatabaseExecuter(Context context) {
        db = new Database(context);
    }

    public SQLiteDatabase getConnection(){
        return db.getWritableDatabase();
    }

    public void insert(SQLiteDatabase db, String tableName, ContentValues contentValues) {
        db.insert(tableName, null, contentValues);
    }

    public <T> ArrayList<T> getAll(SQLiteDatabase db, String tableName, IDatasetReader<T> reader) {
        String qry = "SELECT * FROM " + tableName;
        Cursor dataset = db.rawQuery(qry, null);

        ArrayList<T> values = new ArrayList<>();
        while(dataset.moveToNext()) {
            values.add(reader.read(dataset));
        }
        return values;
    }

    public int getCount(SQLiteDatabase db, String tableName, List<Pair<String, String>> filter) {
        String qry = "SELECT COUNT(*) FROM " + tableName;
        if(filter != null){
            for(int i = 0; i <= filter.size(); i++){
                Pair<String, String> pair = filter.get(i);
                qry += i == 0 ? " WHERE " : " AND ";
                qry += pair.first + " = " + pair.second;
            }
        }

        Cursor dataset = db.rawQuery(qry, null);
        int count = 0;
        if (dataset.moveToNext()){
            count = dataset.getInt(0);
        }
        return count;
    }
}
