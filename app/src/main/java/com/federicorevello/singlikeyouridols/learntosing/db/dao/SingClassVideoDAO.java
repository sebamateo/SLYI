package com.federicorevello.singlikeyouridols.learntosing.db.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.federicorevello.singlikeyouridols.learntosing.db.LearnToSingDbHelper;

/**
 * Created by sebastian on 02/10/14.
 */
public class SingClassVideoDAO {

    private SQLiteDatabase database;
    private LearnToSingDbHelper dbHelper;

    public SingClassVideoDAO(Context context) {
        dbHelper = new LearnToSingDbHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
}
