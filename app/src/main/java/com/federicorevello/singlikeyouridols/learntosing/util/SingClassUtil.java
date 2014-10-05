package com.federicorevello.singlikeyouridols.learntosing.util;

import com.federicorevello.singlikeyouridols.learntosing.db.LearnToSingContract;
import com.federicorevello.singlikeyouridols.learntosing.model.SingClass;
import com.federicorevello.singlikeyouridols.learntosing.model.Video;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by sebastian on 05/10/14.
 */
public class SingClassUtil {

    public static int[] GenerateNewSingClassExerciseList(List<SingClass> singClassList){

        int diferencesToSuccess = 4;
        int diferences = 0;

        int[] newExerciseList = new int[12];
        List<int[]> singClassExerciseList = new ArrayList<int[]>();

        for(Iterator<SingClass> i = singClassList.iterator(); i.hasNext(); ) {
            SingClass singClass = i.next();

            int[] singClassExercise = singClass.getExerciseList();
            singClassExerciseList.add(singClassExercise);
        }

        outerLoop: while (diferences >= diferencesToSuccess){
            newExerciseList = GenerateNewSingClassExerciseList();

            for(Iterator<int[]> i = singClassExerciseList.iterator(); i.hasNext(); ) {
                int[] oldExerciseList = i.next();
                diferences = 0;
                for (int j = 0; j<newExerciseList.length; j++){
                    if(newExerciseList[j]!=(oldExerciseList[j])){
                        diferences++;
                        if(diferences>=diferencesToSuccess){
                            break outerLoop;
                        }
                    }
                }
            }
        }

        return newExerciseList;
    }

    private static int[] GenerateNewSingClassExerciseList(){
        int[] newExerciseList = new int[12];
        Random random = new Random();
        for(int i = 0; i<newExerciseList.length; i++){
            newExerciseList[i] = random.nextInt(5)+1;
        }

        return newExerciseList;
    }
}
