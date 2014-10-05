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

            Cursor cursor = database.query(LearnToSingContract.SingClass.TABLE_NAME,
                    singClassProjectionColumn,
                    selection,
                    new String[]{DateUtils.dateToString(date)},
                    null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();

                singClass = new SingClass();
                singClass.setId(cursor.getInt(cursor.getColumnIndex(LearnToSingContract.SingClass._ID)));

                cursor.close();
            }

            if(singClass != null) {
                StringBuilder selectQuery = new StringBuilder("SELECT ");
                selectQuery.append("v." + LearnToSingContract.Video._ID + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_NAME + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_PATH + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION + ", ");
                selectQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID + ", ");
                selectQuery.append("scv." + LearnToSingContract.SingClassVideo.COLUMN_NAME_IS_COMPLETED + " ");
                selectQuery.append("FROM " + LearnToSingContract.SingClassVideo.TABLE_NAME + " scv ");
                selectQuery.append("INNER JOIN " + LearnToSingContract.Video.TABLE_NAME + " v ON ");
                selectQuery.append("scv." + LearnToSingContract.SingClassVideo.COLUMN_NAME_VIDEO + " = ");
                selectQuery.append("v." + LearnToSingContract.Video._ID + " ");
                selectQuery.append("WHERE scv." + LearnToSingContract.SingClassVideo.COLUMN_NAME_SING_CLASS);
                selectQuery.append(" = " + singClass.getId());
                selectQuery.append(" ORDER BY v." + LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE + " ASC");

                cursor = database.rawQuery(selectQuery.toString(), null);
                Video video = null;
                List<Video> videosList = new ArrayList<Video>();

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        video = new Video();
                        video.setId(cursor.getInt(cursor.getColumnIndex(LearnToSingContract.Video._ID)));
                        video.setName(cursor.getString(cursor.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_NAME)));
                        video.setFilePath(cursor.getString(cursor.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_PATH)));
                        int exerciseType = cursor.getInt(cursor.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE));
                        video.setExerciseType(Video.ExcerciseTypeEnum.values()[exerciseType]);
                        video.setInternalExerciseTypeId(cursor.getInt(cursor.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID)));
                        video.setExplanation(cursor.getInt(cursor.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION)) > 0);
                        video.setCompleted(cursor.getInt(cursor.getColumnIndex(LearnToSingContract.SingClassVideo.COLUMN_NAME_IS_COMPLETED))>0);
                        videosList.add(video.getExerciseType().ordinal(), video);
                    } while (cursor.moveToNext());
                }
                cursor.close();

                singClass.setVideos(videosList);
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

        StringBuilder selectVideosQuery = new StringBuilder("SELECT ");
        selectVideosQuery.append("v." + LearnToSingContract.Video._ID + ", ");
        selectVideosQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_NAME + ", ");
        selectVideosQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_PATH + ", ");
        selectVideosQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE + ", ");
        selectVideosQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION + ", ");
        selectVideosQuery.append("v." + LearnToSingContract.Video.COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID + ", ");
        selectVideosQuery.append("scv." + LearnToSingContract.SingClassVideo.COLUMN_NAME_IS_COMPLETED + " ");
        selectVideosQuery.append("FROM " + LearnToSingContract.SingClassVideo.TABLE_NAME + " scv ");
        selectVideosQuery.append("INNER JOIN " + LearnToSingContract.Video.TABLE_NAME + " v ON ");
        selectVideosQuery.append("scv." + LearnToSingContract.SingClassVideo.COLUMN_NAME_VIDEO + " = ");
        selectVideosQuery.append("v." + LearnToSingContract.Video._ID + " ");
        selectVideosQuery.append("WHERE scv." + LearnToSingContract.SingClassVideo.COLUMN_NAME_SING_CLASS);
        selectVideosQuery.append(" = ?");
        selectVideosQuery.append(" ORDER BY v." + LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE + " ASC");

        try {

            Cursor cursorSC = database.query(LearnToSingContract.SingClass.TABLE_NAME,
                    singClassProjectionColumn,
                    null,
                    null,
                    null, null, LearnToSingContract.SingClass._ID + " DESC", String.valueOf(quantity));

            SingClass singClass = null;

            // looping through all rows and adding to list
            if (cursorSC.moveToFirst()) {
                do {

                    singClass = new SingClass();
                    singClass.setId(cursorSC.getInt(cursorSC.getColumnIndex(LearnToSingContract.SingClass._ID)));

                    Cursor cursorVideo = database.rawQuery(selectVideosQuery.toString(),
                            new String[]{String.valueOf(singClass.getId())});
                    Video video = null;
                    List<Video> videosList = new ArrayList<Video>();

                    // looping through all rows and adding to list
                    if (cursorVideo.moveToFirst()) {
                        do {
                            video = new Video();
                            video.setId(cursorVideo.getInt(cursorVideo.getColumnIndex(LearnToSingContract.Video._ID)));
                            video.setName(cursorVideo.getString(cursorVideo.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_NAME)));
                            video.setFilePath(cursorVideo.getString(cursorVideo.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_PATH)));
                            int exerciseType = cursorVideo.getInt(cursorVideo.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE));
                            video.setExerciseType(Video.ExcerciseTypeEnum.values()[exerciseType]);
                            video.setInternalExerciseTypeId(cursorVideo.getInt(cursorVideo.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID)));
                            video.setExplanation(cursorVideo.getInt(cursorVideo.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION)) > 0);
                            video.setCompleted(cursorVideo.getInt(cursorVideo.getColumnIndex(LearnToSingContract.SingClassVideo.COLUMN_NAME_IS_COMPLETED))>0);

                            videosList.add(video.getExerciseType().ordinal(), video);
                        } while (cursorVideo.moveToNext());
                    }
                    cursorVideo.close();

                    singClass.setVideos(videosList);
                    singClassesList.add(singClass);
                } while (cursorSC.moveToNext());
                cursorSC.close();
            }
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }finally {
            database.close();
        }

        return singClassesList;
    }

}
