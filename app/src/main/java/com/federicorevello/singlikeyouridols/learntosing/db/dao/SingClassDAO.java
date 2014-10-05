package com.federicorevello.singlikeyouridols.learntosing.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.federicorevello.singlikeyouridols.learntosing.db.LearnToSingContract;
import com.federicorevello.singlikeyouridols.learntosing.db.LearnToSingDbHelper;
import com.federicorevello.singlikeyouridols.learntosing.model.SingClass;
import com.federicorevello.singlikeyouridols.learntosing.model.Video;
import com.federicorevello.singlikeyouridols.learntosing.util.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sebastian on 02/10/14.
 */
public class SingClassDAO {

    private static String TAG = "com.federicorevello.singlikeyouridols.learntosing.db.dao.SingClassDAO";

    private SQLiteDatabase database;
    private LearnToSingDbHelper dbHelper;
    private Context context;

    private String[] singClassProjectionColumn = {
            LearnToSingContract.SingClass._ID,
            LearnToSingContract.SingClass.COLUMN_NAME_SING_CLASS_DATE,
            LearnToSingContract.SingClass.COLUMN_NAME_IS_COMPLETED
    };

    private String[] singClassVideoProjectionColumn = {
            LearnToSingContract.SingClassVideo._ID,
            LearnToSingContract.SingClassVideo.COLUMN_NAME_SING_CLASS,
            LearnToSingContract.SingClassVideo.COLUMN_NAME_VIDEO,
            LearnToSingContract.SingClassVideo.COLUMN_NAME_IS_COMPLETED
    };

    public SingClassDAO(Context context) {

        dbHelper = new LearnToSingDbHelper(context);
        this.context = context;
    }

    public SingClass addSingClass(SingClass singClass)
    {
        database = dbHelper.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put(LearnToSingContract.SingClass.COLUMN_NAME_SING_CLASS_DATE,
                    DateUtils.dateToString(singClass.getDate()));
            values.put(LearnToSingContract.SingClass.COLUMN_NAME_IS_COMPLETED,
                    singClass.isCompleted());

            long insertId = database.insert(LearnToSingContract.SingClass.TABLE_NAME, null, values);
            singClass.setId(insertId);

            for(Iterator<Video> i = singClass.getVideos().iterator(); i.hasNext(); ) {
                Video video = i.next();

                values = new ContentValues();
                values.put(LearnToSingContract.SingClassVideo.COLUMN_NAME_SING_CLASS,
                        singClass.getId());
                values.put(LearnToSingContract.SingClassVideo.COLUMN_NAME_VIDEO,
                        video.getId());
                values.put(LearnToSingContract.SingClassVideo.COLUMN_NAME_IS_COMPLETED,
                        video.isCompleted());

                database.insert(LearnToSingContract.SingClassVideo.TABLE_NAME, null, values);
            }

        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }finally {
            database.close();
        }

        return singClass;
    }

    public boolean completeSingClassVideo(long idSingClass, int idVideo){

        boolean ok = false;
        database = dbHelper.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(LearnToSingContract.SingClassVideo.COLUMN_NAME_IS_COMPLETED, true);

            StringBuilder whereClause = new StringBuilder();
            whereClause.append(LearnToSingContract.SingClassVideo.COLUMN_NAME_SING_CLASS + " = ?");
            whereClause.append(" AND ");
            whereClause.append(LearnToSingContract.SingClassVideo.COLUMN_NAME_VIDEO + " = ?");

            int rowsAffected = database.update(LearnToSingContract.SingClassVideo.TABLE_NAME,
                    values,
                    whereClause.toString(),
                    new String[]{String.valueOf(idSingClass), String.valueOf(idVideo)});
            ok = rowsAffected > 0;
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }finally {
            database.close();
        }
        return ok;
    }

    public boolean completeSingClass(long idSingClass){

        boolean ok = false;
        database = dbHelper.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(LearnToSingContract.SingClass.COLUMN_NAME_IS_COMPLETED, true);

            int rowsAffected = database.update(LearnToSingContract.SingClass.TABLE_NAME,
                    values,
                    LearnToSingContract.SingClass._ID + " = ?",
                    new String[]{String.valueOf(idSingClass)});
            ok = rowsAffected > 0;
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }finally {
            database.close();
        }
        return ok;
    }

    public SingClass getSingClass(Date date){

        SingClass singClass = null;
        database = dbHelper.getReadableDatabase();

        try {

            String selection = LearnToSingContract.SingClass.COLUMN_NAME_SING_CLASS_DATE + " = ?";

            Cursor c = database.query(LearnToSingContract.SingClass.TABLE_NAME,
                    singClassProjectionColumn,
                    selection,
                    new String[]{DateUtils.dateToString(date)},
                    null, null, null);

            if (c != null) {
                c.moveToFirst();

                singClass = new SingClass();
                singClass.setId(c.getInt(c.getColumnIndex(LearnToSingContract.SingClass._ID)));
            }

            if(singClass != null) {
                StringBuilder selectQuery = new StringBuilder("SELECT ");
                selectQuery.append("v." + LearnToSingContract.Video._ID + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_NAME + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_PATH + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_VIDEO_ID + ", ");
                selectQuery.append("scv." + LearnToSingContract.SingClassVideo.COLUMN_NAME_IS_COMPLETED + " ");
                selectQuery.append("FROM " + LearnToSingContract.SingClassVideo.TABLE_NAME + " scv ");
                selectQuery.append("INNER JOIN " + LearnToSingContract.Video.TABLE_NAME + " v ON ");
                selectQuery.append("scv." + LearnToSingContract.SingClassVideo.COLUMN_NAME_VIDEO + " = ");
                selectQuery.append("v." + LearnToSingContract.Video._ID + " ");
                selectQuery.append("WHERE scv." + LearnToSingContract.SingClassVideo.COLUMN_NAME_SING_CLASS);
                selectQuery.append(" = " + singClass.getId());
                selectQuery.append(" ORDER BY v." + LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE + " ASC");

                c = database.rawQuery(selectQuery.toString(), null);

                //TODO Recorrer los objetos
            }
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }finally {
            database.close();
        }

        return singClass;
    }

    public List<SingClass> getLastSingClasses(int quantity){

        List<SingClass> singClassesList = new ArrayList<SingClass>();
        database = dbHelper.getReadableDatabase();

        try {


        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }finally {
            database.close();
        }

        return singClassesList;
    }

}
