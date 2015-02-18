package com.github.commissionergordon.scheduler.classes;

import java.util.Date;

/**
 * Created by jusfern on 2/17/2015.
 */
public class DayConstraint {
    private int constraint_id;
    private Date day;

    DayConstraint(int constraint_id, Date day){
        this.constraint_id = constraint_id;
        this.day = day;
    }

    DayConstraint(DayConstraint dayConstraint){
        this.constraint_id = dayConstraint.constraint_id;
        this.day = dayConstraint.day;
    }
}
