package com.juancrud.petagram.db;

import android.content.ContentValues;

public interface IValueParser<T> {
    ContentValues parseValues(T t);
}
