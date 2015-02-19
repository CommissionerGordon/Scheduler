package com.github.commissionergordon.scheduler.classes;

import java.util.Date;

/**
 * Created by jusfern on 2/17/2015.
 */
public class TimeConstraint {
    public boolean can;
    private int constraint_id;
    private Date endTime;
    private Date startTime;

    TimeConstraint(boolean can, int constraint_id, Date endTime, Date startTime){
        this.can = can;
        this.constraint_id = constraint_id;
        this.endTime = endTime;
        this.endTime = startTime;
    }

    TimeConstraint(TimeConstraint timeConstraint){
        this.can = timeConstraint.can;
        this.constraint_id = timeConstraint.constraint_id;
        this.endTime = timeConstraint.endTime;
        this.startTime = timeConstraint.startTime;
    }
}
