package com.github.commissionergordon.scheduler.classes;

/*
    MonthConstraint Table Schema

    MONTH_CONSTRAINT_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACTIVITY_ID         INTEGER NOT NULL,
    CAN                 BOOLEAN NOT NULL,
    JANUARY             BOOLEAN DEFAULT FALSE NOT NULL,
    FEBRUARY            BOOLEAN DEFAULT FALSE NOT NULL,
    MARCH               BOOLEAN DEFAULT FALSE NOT NULL,
    APRIL               BOOLEAN DEFAULT FALSE NOT NULL,
    MAY                 BOOLEAN DEFAULT FALSE NOT NULL,
    JUNE                BOOLEAN DEFAULT FALSE NOT NULL,
    JULY                BOOLEAN DEFAULT FALSE NOT NULL,
    AUGUST              BOOLEAN DEFAULT FALSE NOT NULL,
    SEPTEMBER           BOOLEAN DEFAULT FALSE NOT NULL,
    OCTOBER             BOOLEAN DEFAULT FALSE NOT NULL,
    NOVEMBER            BOOLEAN DEFAULT FALSE NOT NULL,
    DECEMBER            BOOLEAN DEFAULT FALSE NOT NULL
*/

public class MonthConstraint {
    private int id;
    private boolean can;
    private int activity_id;
    public boolean january;
    public boolean february;
    public boolean march;
    public boolean april;
    public boolean may;
    public boolean june;
    public boolean july;
    public boolean august;
    public boolean september;
    public boolean october;
    public boolean november;
    public boolean december;

    public MonthConstraint(int id, int activity_id, boolean can){
        this.id = id;
        this.activity_id = activity_id;
        this.can = can;
    }
}
