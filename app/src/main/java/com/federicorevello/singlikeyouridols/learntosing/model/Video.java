package com.federicorevello.singlikeyouridols.learntosing.model;

/**
 * Created by sebastian on 01/10/14.
 */
public class Video {

    public enum ExcerciseTypeEnum {BREATHING, WARM_UP, MAJOR_SCALE, MINOR_SCALE, CHROMATIC,
        PASAGGIOS, SUSTAIN, HIGH_NOTES, STACATO, VIBRATO, PERFECT_PITCH, RUNS_N_RIFFS}

    private int id;
    private String name;
    private String filePath;
    private ExcerciseTypeEnum exerciseType;
    private int internalExerciseTypeId;
    private boolean explanation;
    private boolean completed ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ExcerciseTypeEnum getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExcerciseTypeEnum exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getInternalExerciseTypeId() {
        return internalExerciseTypeId;
    }

    public void setInternalExerciseTypeId(int internalExerciseTypeId) {
        this.internalExerciseTypeId = internalExerciseTypeId;
    }

    public boolean isExplanation() {
        return explanation;
    }

    public void setExplanation(boolean explanation) {
        this.explanation = explanation;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
