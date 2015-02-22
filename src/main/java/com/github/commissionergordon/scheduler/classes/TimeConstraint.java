package com.github.commissionergordon.scheduler.classes;

import java.util.Date;

/*
    TimeConstraint Table Schema

    TIME_CONSTRAINT_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACTIVITY_ID        INTEGER NOT NULL,
    CAN                BOOLEAN,
    STARTTIME          TIME,
    ENDTIME            TIME
*/

public class TimeConstraint {
    private int id;
    private int activity_id;
    private boolean can;
    private Date startTime;
    private Date endTime;

    public TimeConstraint(int id, int activity_id, boolean can, Date startTime, Date endTime){
        this.id = id;
        this.activity_id = activity_id;
        this.can = can;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
