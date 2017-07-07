package com.juancrud.petagram.db;

import android.database.Cursor;

public interface IDatasetReader<T> {
    T read(Cursor dataset);
}
