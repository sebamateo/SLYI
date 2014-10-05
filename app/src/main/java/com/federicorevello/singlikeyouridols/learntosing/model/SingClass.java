package com.federicorevello.singlikeyouridols.learntosing.model;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sebastian on 01/10/14.
 */
public class SingClass {

    private long id;
    private Date date;
    private boolean isCompleted;
    private List<Video> videos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public List<Video> getVideos(){
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public int[] getExerciseList()
    {
        int[] exerciseList = new int[12];

        for(Iterator<Video> i = this.getVideos().iterator(); i.hasNext(); ) {
            Video video = i.next();
            exerciseList[video.getExerciseType().ordinal()] = video.getInternalExerciseTypeId();
        }

        return exerciseList;
    }
}
