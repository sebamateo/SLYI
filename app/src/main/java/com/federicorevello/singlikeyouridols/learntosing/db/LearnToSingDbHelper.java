package com.federicorevello.singlikeyouridols.learntosing.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sebastian on 29/09/14.
 */
public class LearnToSingDbHelper extends SQLiteOpenHelper{

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LearnToSing.db";


    public LearnToSingDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LearnToSingContract.Video.CREATE_TABLE);
        db.execSQL(LearnToSingContract.SingClass.CREATE_TABLE);
        db.execSQL(LearnToSingContract.SingClassVideo.CREATE_TABLE);

        db.execSQL(LearnToSingContract.Video.INSERT_ROW_1);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_2);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_3);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_4);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_5);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_6);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_7);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_8);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_9);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_10);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_11);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_12);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_13);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_14);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_15);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_16);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_17);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_18);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_19);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_20);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_21);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_22);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_23);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_24);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_25);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_26);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_27);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_28);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_29);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_30);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_31);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_32);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_33);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_34);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_35);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_36);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_37);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_38);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_39);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_40);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_41);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_42);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_43);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_44);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_45);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_46);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_47);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_48);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_49);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_50);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_51);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_52);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_53);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_54);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_55);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_56);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_57);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_58);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_59);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_60);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_61);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_62);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_63);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_64);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_65);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_66);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_67);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_68);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_69);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_70);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_71);
        db.execSQL(LearnToSingContract.Video.INSERT_ROW_72);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(LearnToSingContract.Video.SQL_DELETE);
        db.execSQL(LearnToSingContract.SingClass.SQL_DELETE);
        db.execSQL(LearnToSingContract.SingClassVideo.SQL_DELETE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
