package com.github.commissionergordon.scheduler.classes;

import java.util.Date;

/**
 * Created by jusfern on 2/17/2015.
 */
public class Activity {
    private float duration;
    private boolean enabled;
    private int id;
    private String name;
    private int parts;
    private int priority;
    private Date startTime;
    private int user_id;

    Activity(float duration, int id, String name, int user_id){
        this.duration = duration;
        this.id = id;
        this.name = name;
        this.user_id = user_id;

        this.enabled = false;
        this.parts = 1;
        this.priority = 0;
    }

    Activity(Activity activity){
        this.duration = activity.duration;
        this.enabled = activity.enabled;
        this.id = activity.id;
        this.name = activity.name;
        this.parts = activity.parts;
        this.priority = activity.priority;
        this.startTime = activity.startTime;
        this.user_id = activity.user_id;
    }

    Activity(float duration, boolean enabled, int id, String name, int parts, int priority, Date startTime, int user_id){
        this.duration = duration;
        this.enabled = enabled;
        this.id = id;
        this.name = name;
        this.parts = parts;
        this.priority = priority;
        this.startTime = startTime;
        this.user_id = user_id;
    }
}
