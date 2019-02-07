package com.testing.android.proof.data.database;


import java.sql.Timestamp;
import java.util.Date;

import androidx.room.TypeConverter;

public final class Converters {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Timestamp(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}