package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.interfaces.Constraint;

import java.util.Date;

/*
    DateConstraint Table Schema

    DATE_CONSTRAINT_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACTIVITY_ID        INTEGER NOT NULL,
    DATE               DATE NOT NULL
*/

public class DateConstraint implements Constraint {
    private int activity_id;
    private Date date;

    public DateConstraint(int activity_id, Date date){
        this.activity_id = activity_id;
        this.date = date;
    }
}
