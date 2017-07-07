package com.juancrud.petagram.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public interface IDatasetReader<T> {
    T read(Cursor dataset, SQLiteDatabase db);
}
