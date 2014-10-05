package com.federicorevello.singlikeyouridols.learntosing.db;

import android.provider.BaseColumns;

/**
 * Created by sebastian on 29/09/14.
 */
public final class LearnToSingContract {

    public LearnToSingContract(){}

    public static class SingClass implements BaseColumns {

        public static final String TABLE_NAME = "video";
        //public static final String COLUMN_NAME_SING_CLASS_ID = "sing_class_id";
        public static final String COLUMN_NAME_SING_CLASS_DATE = "sing_class_date";
        public static final String COLUMN_NAME_IS_COMPLETED = "is_completed";

        // SQL statement to create book table
        public static final String CREATE_TABLE = "CREATE TABLE" +  TABLE_NAME + " ( " +
                SingClass._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_SING_CLASS_DATE + " DATETIME DEFAULT CURRENT_DATE, "+
                COLUMN_NAME_IS_COMPLETED + " INTEGER );";

        public static final String SQL_DELETE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class SingClassVideo implements BaseColumns {

        public static final String TABLE_NAME = "sing_class_video";
        //public static final String COLUMN_NAME_SING_CLASS_VIDEO_ID = "sing_class_video_id";
        public static final String COLUMN_NAME_SING_CLASS = "sing_class";
        public static final String COLUMN_NAME_VIDEO = "video";
        public static final String COLUMN_NAME_IS_COMPLETED = "is_completed";

        // SQL statement to create book table
        public static final String CREATE_TABLE = "CREATE TABLE" +  TABLE_NAME + " ( " +
                SingClassVideo._ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME_SING_CLASS + " INTEGER, " +
                COLUMN_NAME_VIDEO + " INTEGER, "+
                COLUMN_NAME_IS_COMPLETED + " INTEGER );";

        public static final String SQL_DELETE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class Video implements BaseColumns{

        public static final String TABLE_NAME = "video";
        public static final String COLUMN_NAME_NAME = "video_name";
        public static final String COLUMN_NAME_PATH = "video_path";
        public static final String COLUMN_NAME_EXERCISE_TYPE = "video_exercise_type";
        public static final String COLUMN_NAME_IS_EXPLANATION = "video_is_explanation";
        public static final String COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID = "video_internal_exercise_type_id";

        public static final String VIDEO_DIRECTORY_PATH = "";
        public static final String VIDEO_FILE_TYPE = "";
        //public static final String VIDEO_FILE_TYPE = ".mp4";

        // SQL statement to create book table
        public static final String CREATE_TABLE = "CREATE TABLE" +  TABLE_NAME + " ( " +
                Video._ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME_NAME + " TEXT, "+
                COLUMN_NAME_PATH + " TEXT, "+
                COLUMN_NAME_EXERCISE_TYPE + " INTEGER, "+
                COLUMN_NAME_INTERNAL_EXERCISE_TYPE_ID + " INTEGER," +
                COLUMN_NAME_IS_EXPLANATION + " INTEGER);";

        public static final String SQL_DELETE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

        //BREATHING videos
        public static final String INSERT_ROW_1 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "1, 'BREATHING-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "BREATHING-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.BREATHING.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_2 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "2, 'BREATHING-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "BREATHING-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.BREATHING.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_3 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "3, 'BREATHING-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "BREATHING-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.BREATHING.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_4 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "4, 'BREATHING-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "BREATHING-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.BREATHING.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_5 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "5, 'BREATHING-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "breathing-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.BREATHING.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_6 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "6, 'BREATHING-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "BREATHING-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.BREATHING.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //WARM_UP videos
        public static final String INSERT_ROW_7 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "7, 'WARM_UP-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "WARM_UP-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.WARM_UP.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_8 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "8, 'WARM_UP-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "WARM_UP-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.WARM_UP.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_9 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "9, 'WARM_UP-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "WARM_UP-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.WARM_UP.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_10 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "10, 'WARM_UP-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "WARM_UP-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.WARM_UP.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_11 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "11, 'WARM_UP-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "WARM_UP-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.WARM_UP.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_12 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "12, 'WARM_UP-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "WARM_UP-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.WARM_UP.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //MAJOR_SCALE videos
        public static final String INSERT_ROW_13 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "13, 'MAJOR_SCALE-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "MAJOR_SCALE-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MAJOR_SCALE.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_14 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "14, 'MAJOR_SCALE-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "MAJOR_SCALE-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MAJOR_SCALE.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_15 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "15, 'MAJOR_SCALE-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "MAJOR_SCALE-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MAJOR_SCALE.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_16 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "16, 'MAJOR_SCALE-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "MAJOR_SCALE-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MAJOR_SCALE.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_17 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "17, 'MAJOR_SCALE-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "MAJOR_SCALE-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MAJOR_SCALE.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_18 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "18, 'MAJOR_SCALE-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "MAJOR_SCALE-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MAJOR_SCALE.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //MINOR_SCALE videos
        public static final String INSERT_ROW_19 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "19, 'MINOR_SCALE-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "MINOR_SCALE-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MINOR_SCALE.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_20 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "20, 'MINOR_SCALE-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "MINOR_SCALE-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MINOR_SCALE.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_21 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "21, 'MINOR_SCALE-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "MINOR_SCALE-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MINOR_SCALE.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_22 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "22, 'MINOR_SCALE-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "MINOR_SCALE-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MINOR_SCALE.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_23 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "23, 'MINOR_SCALE-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "MINOR_SCALE-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MINOR_SCALE.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_24 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "24, 'MINOR_SCALE-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "MINOR_SCALE-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.MINOR_SCALE.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //CHROMATIC videos
        public static final String INSERT_ROW_25 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "25, 'CHROMATIC-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "CHROMATIC-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.CHROMATIC.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_26 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "26, 'CHROMATIC-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "CHROMATIC-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.CHROMATIC.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_27 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "27, 'CHROMATIC-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "CHROMATIC-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.CHROMATIC.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_28 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "28, 'CHROMATIC-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "CHROMATIC-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.CHROMATIC.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_29 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "29, 'CHROMATIC-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "CHROMATIC-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.CHROMATIC.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_30 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "30, 'CHROMATIC-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "CHROMATIC-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.CHROMATIC.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //PASAGGIOS videos
        public static final String INSERT_ROW_31 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "31, 'PASAGGIOS-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "PASAGGIOS-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PASAGGIOS.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_32 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "32, 'PASAGGIOS-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "PASAGGIOS-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PASAGGIOS.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_33 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "33, 'PASAGGIOS-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "PASAGGIOS-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PASAGGIOS.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_34 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "34, 'PASAGGIOS-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "PASAGGIOS-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PASAGGIOS.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_35 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "35, 'PASAGGIOS-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "PASAGGIOS-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PASAGGIOS.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_36 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "36, 'PASAGGIOS-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "PASAGGIOS-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PASAGGIOS.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //SUSTAIN videos
        public static final String INSERT_ROW_37 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "37, 'SUSTAIN-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "SUSTAIN-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.SUSTAIN.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_38 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "38, 'SUSTAIN-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "SUSTAIN-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.SUSTAIN.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_39 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "39, 'SUSTAIN-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "SUSTAIN-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.SUSTAIN.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_40 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "40, 'SUSTAIN-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "SUSTAIN-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.SUSTAIN.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_41 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "41, 'SUSTAIN-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "SUSTAIN-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.SUSTAIN.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_42 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "42, 'SUSTAIN-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "SUSTAIN-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.SUSTAIN.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //HIGH_NOTES videos
        public static final String INSERT_ROW_43 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "43, 'HIGH_NOTES-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "HIGH_NOTES-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.HIGH_NOTES.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_44 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "44, 'HIGH_NOTES-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "HIGH_NOTES-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.HIGH_NOTES.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_45 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "45, 'HIGH_NOTES-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "HIGH_NOTES-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.HIGH_NOTES.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_46 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "46, 'HIGH_NOTES-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "HIGH_NOTES-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.HIGH_NOTES.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_47 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "47, 'HIGH_NOTES-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "HIGH_NOTES-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.HIGH_NOTES.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_48 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "48, 'HIGH_NOTES-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "HIGH_NOTES-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.HIGH_NOTES.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //STACATO videos
        public static final String INSERT_ROW_49 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "49, 'STACATO-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "STACATO-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.STACATO.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_50 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "50, 'STACATO-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "STACATO-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.STACATO.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_51 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "51, 'STACATO-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "STACATO-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.STACATO.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_52 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "52, 'STACATO-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "STACATO-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.STACATO.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_53 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "53, 'STACATO-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "STACATO-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.STACATO.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_54 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "54, 'STACATO-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "STACATO-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.STACATO.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //VIBRATO videos
        public static final String INSERT_ROW_55 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "55, 'VIBRATO-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "VIBRATO-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.VIBRATO.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_56 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "56, 'VIBRATO-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "VIBRATO-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.VIBRATO.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_57 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "57, 'VIBRATO-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "VIBRATO-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.VIBRATO.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_58 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "58, 'VIBRATO-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "VIBRATO-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.VIBRATO.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_59 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "59, 'VIBRATO-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "VIBRATO-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.VIBRATO.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_60 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "60, 'VIBRATO-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "VIBRATO-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.VIBRATO.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //PERFECT_PITCH videos
        public static final String INSERT_ROW_61 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "61, 'PERFECT_PITCH-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "PERFECT_PITCH-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PERFECT_PITCH.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_62 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "62, 'PERFECT_PITCH-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "PERFECT_PITCH-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PERFECT_PITCH.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_63 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "63, 'PERFECT_PITCH-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "PERFECT_PITCH-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PERFECT_PITCH.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_64 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "64, 'PERFECT_PITCH-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "PERFECT_PITCH-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PERFECT_PITCH.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_65 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "65, 'PERFECT_PITCH-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "PERFECT_PITCH-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PERFECT_PITCH.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_66 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "66, 'PERFECT_PITCH-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "PERFECT_PITCH-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.PERFECT_PITCH.ordinal() +
                ", 0" +
                ", 1" +
                ");";

        //RUNS_N_RIFFS videos
        public static final String INSERT_ROW_67 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "67, 'RUNS_N_RIFFS-1', " +
                "'" + VIDEO_DIRECTORY_PATH + "RUNS_N_RIFFS-1" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.RUNS_N_RIFFS.ordinal() +
                ", 1" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_68 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "68, 'RUNS_N_RIFFS-2', " +
                "'" + VIDEO_DIRECTORY_PATH + "RUNS_N_RIFFS-2" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.RUNS_N_RIFFS.ordinal() +
                ", 2" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_69 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "69, 'RUNS_N_RIFFS-3', " +
                "'" + VIDEO_DIRECTORY_PATH + "RUNS_N_RIFFS-3" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.RUNS_N_RIFFS.ordinal() +
                ", 3" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_70 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "70, 'RUNS_N_RIFFS-4', " +
                "'" + VIDEO_DIRECTORY_PATH + "RUNS_N_RIFFS-4" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.RUNS_N_RIFFS.ordinal() +
                ", 4" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_71 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "71, 'RUNS_N_RIFFS-5', " +
                "'" + VIDEO_DIRECTORY_PATH + "RUNS_N_RIFFS-5" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.RUNS_N_RIFFS.ordinal() +
                ", 5" +
                ", 0" +
                ");";

        public static final String INSERT_ROW_72 = "INSERT INTO " + TABLE_NAME + " VALUES(" +
                "72, 'RUNS_N_RIFFS-explanation', " +
                "'" + VIDEO_DIRECTORY_PATH + "RUNS_N_RIFFS-explanation" + VIDEO_FILE_TYPE + "', " +
                com.federicorevello.singlikeyouridols.learntosing.model.Video.ExcerciseTypeEnum.RUNS_N_RIFFS.ordinal() +
                ", 0" +
                ", 1" +
                ");";
    }
}
