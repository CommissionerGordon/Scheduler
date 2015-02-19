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

    MonthConstraint(MonthConstraint monthConstraint){
        this.can = monthConstraint.can;
        this.constraint_id = monthConstraint.constraint_id;
        this.january = monthConstraint.january;
        this.february = monthConstraint.february;
        this.march = monthConstraint.march;
        this.april = monthConstraint.april;
        this.may = monthConstraint.may;
        this.june = monthConstraint.june;
        this.july = monthConstraint.july;
        this.august = monthConstraint.august;
        this.september = monthConstraint.september;
        this.october = monthConstraint.october;
        this.november = monthConstraint.november;
        this.december = monthConstraint.december;
    }
}
