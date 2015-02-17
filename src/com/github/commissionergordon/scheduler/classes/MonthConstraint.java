package com.github.commissionergordon.scheduler.classes;

/**
 * Created by jusfern on 2/17/2015.
 */
public class MonthConstraint {
    public boolean can;
    private int constraint_id;
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

    MonthConstraint(boolean can, int constraint_id){
        this.can = can;
        this.constraint_id = constraint_id;
    }
}
