package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.interfaces.Constraint;
import com.github.commissionergordon.scheduler.interfaces.SQLObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    Activity Table Schema

    ACTIVITY_ID        INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    USER_ID            INTEGER NOT NULL,
    ACTIVITY_NAME      VARCHAR(30) NOT NULL,
    ACTIVITY_DURATION  TIMESTAMP NOT NULL,
    ACTIVITY_ENABLED   BOOLEAN DEFAULT TRUE NOT NULL,
    ACTIVITY_STARTTIME TIME,
    ACTIVITY_PRIORITY  INTEGER DEFAULT 0 NOT NULL
*/

public class Activity implements SQLObject {
    private int id;
    private int user_id;
    private String name;
    private Date duration;
    private boolean enabled;
    private Time startTime;
    private int priority;

    private List<Constraint> constraints;

    public Activity(int id, int user_id, String name, Date duration, boolean enabled, Time startTime, int priority){
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.duration = duration;
        this.enabled = enabled;
        this.startTime = startTime;
        this.priority = priority;

        constraints = new ArrayList<Constraint>();
    }

    @Override
    public String getUpdateString() {
        return null;
    }
}
