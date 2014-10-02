package com.federicorevello.singlikeyouridols.learntosing.db.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.federicorevello.singlikeyouridols.learntosing.db.LearnToSingContract;
import com.federicorevello.singlikeyouridols.learntosing.db.LearnToSingDbHelper;
import com.federicorevello.singlikeyouridols.learntosing.model.Video;

/**
 * Created by sebastian on 02/10/14.
 */
public class VideoDAO {

    // Logcat tag
    private static final String LOG = "VideoDAO";

    private SQLiteDatabase database;
    private LearnToSingDbHelper dbHelper;

    public VideoDAO(Context context) {
        dbHelper = new LearnToSingDbHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    String[] projection = {
            LearnToSingContract.Video._ID,
            LearnToSingContract.Video.COLUMN_NAME_NAME,
            LearnToSingContract.Video.COLUMN_NAME_PATH,
            LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE,
            LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION,
            LearnToSingContract.Video.COLUMN_NAME_VIDEO_ID
    };

    public Video getVideoById(int id){

        String selectQuery = "SELECT * FROM " +
                LearnToSingContract.Video.TABLE_NAME +
                " WHERE " + LearnToSingContract.Video._ID + " = " + id;

        Log.e(LOG, selectQuery);

        Cursor c = database.rawQuery(selectQuery, null);

        Video video = null;

        if (c != null) {
            c.moveToFirst();

            video = new Video();
            video.setId(c.getInt(c.getColumnIndex(LearnToSingContract.Video._ID)));
            video.setName(c.getString(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_NAME)));
            video.setFilePath(c.getString(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_PATH)));
            int exerciseType = c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_EXERCISE_TYPE));
            video.setExerciseType(Video.ExcerciseTypeEnum.values()[exerciseType]);
            video.setExplanation(c.getInt(c.getColumnIndex(LearnToSingContract.Video.COLUMN_NAME_IS_EXPLANATION))>0);
        }

        return video;
    }


}
