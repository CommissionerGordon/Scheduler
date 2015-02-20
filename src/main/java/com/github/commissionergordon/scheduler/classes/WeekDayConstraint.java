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

    WeekDayConstraint(WeekDayConstraint weekDayConstraint){
        this.can = weekDayConstraint.can;
        this.constraint_id = weekDayConstraint.constraint_id;

        this.monday = weekDayConstraint.monday;
        this.tuesday = weekDayConstraint.tuesday;
        this.wednesday = weekDayConstraint.wednesday;
        this.thursday = weekDayConstraint.thursday;
        this.friday = weekDayConstraint.friday;
        this.saturday = weekDayConstraint.saturday;
        this.sunday = weekDayConstraint.sunday;
    }
}
