package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.interfaces.SQLObject;

/*
    WeekDayConstraint Table Schema

    WEEKDAY_CONSTRAINT_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACTIVITY_ID           INTEGER NOT NULL,
    CAN                   BOOLEAN NOT NULL,
    SUNDAY                BOOLEAN DEFAULT FALSE NOT NULL,
    MONDAY                BOOLEAN DEFAULT FALSE NOT NULL,
    TUESDAY               BOOLEAN DEFAULT FALSE NOT NULL,
    WEDNESDAY             BOOLEAN DEFAULT FALSE NOT NULL,
    THURSDAY              BOOLEAN DEFAULT FALSE NOT NULL,
    FRIDAY                BOOLEAN DEFAULT FALSE NOT NULL,
    SATURDAY              BOOLEAN DEFAULT FALSE NOT NULL
*/

public class WeekDayConstraint implements SQLObject {
    private int id;
    private boolean can;
    private int activity_id;

    public boolean monday;
    public boolean tuesday;
    public boolean wednesday;
    public boolean thursday;
    public boolean friday;
    public boolean saturday;
    public boolean sunday;

    public WeekDayConstraint(int id, int activity_id, boolean can, boolean sunday, boolean monday, boolean tuesday,
                             boolean wednesday, boolean thursday, boolean friday, boolean saturday) {
        this.id = id;
        this.activity_id = activity_id;
        this.can = can;

        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    @Override
    public String getUpdateString() {
        return null;
    }
}
