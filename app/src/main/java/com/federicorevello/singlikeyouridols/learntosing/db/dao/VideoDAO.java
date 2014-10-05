package com.federicorevello.singlikeyouridols.learntosing.db.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.federicorevello.singlikeyouridols.learntosing.db.LearnToSingContract;
import com.federicorevello.singlikeyouridols.learntosing.db.LearnToSingDbHelper;
import com.federicorevello.singlikeyouridols.learntosing.model.Video;

/**
 * Created by sebastian on 02/10/14.
 */
public class VideoDAO {

    private static final String TAG = "com.federicorevello.singlikeyouridols.learntosing.db.dao.VideoDAO";

    private SQLiteDatabase database;
    private LearnToSingDbHelper dbHelper;
    private Context context;

    public VideoDAO(Context context) {

        dbHelper = new LearnToSingDbHelper(context);
        this.context = context;
    }

    String[] projection = {
            LearnToSingContract.Video._ID,
            LearnToSingContract.Video.COLUMN_NAME_NAME,
            LearnToSingContract.Video.COLUMN_NAME_PATH,
            LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE,
            LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION,
            LearnToSingContract.Video.COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID
    };

    public Video getVideoById(int id){

        database = dbHelper.getReadableDatabase();
        Video video = null;

        try {

            String selectQuery = "SELECT * FROM " +
                    LearnToSingContract.Video.TABLE_NAME +
                    " WHERE " + LearnToSingContract.Video._ID + " = " + id;

            Cursor c = database.rawQuery(selectQuery, null);

            if (c != null) {
                c.moveToFirst();

                video = new Video();
                video.setId(c.getInt(c.getColumnIndex(LearnToSingContract.Video._ID)));
                video.setName(c.getString(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_NAME)));
                video.setFilePath(c.getString(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_PATH)));
                int exerciseType = c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE));
                video.setExerciseType(Video.ExcerciseTypeEnum.values()[exerciseType]);
                video.setInternalExerciseTypeId(c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID)));
                video.setExplanation(c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION))>0);
            }
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }finally {
            database.close();
        }

        return video;
    }

    public Video getVideoByExerciseType(int internalExerciseId, Video.ExcerciseTypeEnum exerciseType){

        database = dbHelper.getReadableDatabase();
        Video video = null;

        try {

            String selectQuery = "SELECT * FROM " +
                    LearnToSingContract.Video.TABLE_NAME +
                    " WHERE " +
                    LearnToSingContract.Video.COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID + " = " + internalExerciseId +
                    " AND " +
                    LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE + " = " + exerciseType.ordinal();

            Cursor c = database.rawQuery(selectQuery, null);

            if (c != null) {
                c.moveToFirst();

                video = new Video();
                video.setId(c.getInt(c.getColumnIndex(LearnToSingContract.Video._ID)));
                video.setName(c.getString(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_NAME)));
                video.setFilePath(c.getString(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_PATH)));
                int exerciseTypeSelect = c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE));
                video.setExerciseType(Video.ExcerciseTypeEnum.values()[exerciseTypeSelect]);
                video.setInternalExerciseTypeId(c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID)));
                video.setExplanation(c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION))>0);
            }
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }finally {
            database.close();
        }

        return video;
    }

    public Video getVideoByExerciseTypeExplanation(Video.ExcerciseTypeEnum exerciseType){

        database = dbHelper.getReadableDatabase();
        Video video = null;

        try {

            String selectQuery = "SELECT * FROM " +
                    LearnToSingContract.Video.TABLE_NAME +
                    " WHERE " +
                    LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION + " = 1 " +
                    " AND " +
                    LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE + " = " + exerciseType.ordinal();

            Cursor c = database.rawQuery(selectQuery, null);

            if (c != null) {
                c.moveToFirst();

                video = new Video();
                video.setId(c.getInt(c.getColumnIndex(LearnToSingContract.Video._ID)));
                video.setName(c.getString(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_NAME)));
                video.setFilePath(c.getString(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_PATH)));
                int exerciseTypeSelect = c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE));
                video.setExerciseType(Video.ExcerciseTypeEnum.values()[exerciseTypeSelect]);
                video.setInternalExerciseTypeId(c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID)));
                video.setExplanation(c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION))>0);
            }
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }finally {
            database.close();
        }

        return video;
    }
}
