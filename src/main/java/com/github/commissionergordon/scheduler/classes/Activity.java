package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.interfaces.Constraint;
import com.github.commissionergordon.scheduler.interfaces.SQLObject;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    Activity Table Schema

    ACTIVITY_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    USER_ID     INTEGER NOT NULL,
    NAME        VARCHAR(30) NOT NULL,
    DURATION    TIMESTAMP NOT NULL,
    ENABLED     BOOLEAN DEFAULT TRUE NOT NULL,
    STARTTIME   TIME,
    PRIORITY    INTEGER DEFAULT 0 NOT NULL
*/

public class Activity implements SQLObject {
    public int id;
    public int user_id;
    public String name;
    public LocalTime duration;
    public boolean enabled;
    public LocalTime startTime;
    public int priority;

    private List<Constraint> constraints = new ArrayList<Constraint>();

    public Activity(int id, int user_id, String name, LocalTime duration, boolean enabled, LocalTime startTime, int priority){
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.duration = duration;
        this.enabled = enabled;
        this.startTime = startTime;
        this.priority = priority;
    }

    public Activity(int id, int user_id, String name, LocalTime duration){
        this(id, user_id, name, duration, true, null, 1);
    }

    @Override
    public String getUpdateString() {
        return null;
    }
}
