package com.github.commissionergordon.scheduler.classes;

/**
 * Created by jusfern on 2/17/2015.
 */
public class WeekDayConstraint {
    public boolean can;
    private int constraint_id;

    public boolean monday;
    public boolean tuesday;
    public boolean wednesday;
    public boolean thursday;
    public boolean friday;
    public boolean saturday;
    public boolean sunday;

    WeekDayConstraint(boolean can, int constraint_id){
        this.can = can;
        this.constraint_id = constraint_id;
    }
}
