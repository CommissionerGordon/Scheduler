package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.Main;
import com.github.commissionergordon.scheduler.interfaces.Constraint;
import com.github.commissionergordon.scheduler.interfaces.SQLObject;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.github.commissionergordon.scheduler.jooq.generated.Tables.MONTH_CONSTRAINT;

public class MonthConstraint implements Constraint, SQLObject {
    private int id;
	private Activity activity;
    private boolean can;

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

    public MonthConstraint(int id, Activity activity, boolean can){
        this.id = id;
        this.activity = activity;
        this.can = can;
    }

	@Override
	public void update() throws SQLException {
		try(Connection conn = DriverManager.getConnection(Main.getDBConnectionString(), Main.getDbUser(), "")) {
			DSLContext database = DSL.using(conn);

			database.update(MONTH_CONSTRAINT)
				.set(MONTH_CONSTRAINT.CAN, can)
				.set(MONTH_CONSTRAINT.JANUARY, january)
				.set(MONTH_CONSTRAINT.FEBRAURY, february)
				.set(MONTH_CONSTRAINT.MARCH, march)
				.set(MONTH_CONSTRAINT.APRIL, april)
				.set(MONTH_CONSTRAINT.MAY, may)
				.set(MONTH_CONSTRAINT.JUNE, june)
				.set(MONTH_CONSTRAINT.JULY, july)
				.set(MONTH_CONSTRAINT.AUGUST, august)
				.set(MONTH_CONSTRAINT.SEPTEMBER, september)
				.set(MONTH_CONSTRAINT.OCTOBER, october)
				.set(MONTH_CONSTRAINT.NOVEMBER, november)
				.set(MONTH_CONSTRAINT.DECEMBER, december)
				.where(MONTH_CONSTRAINT.MONTH_CONSTRAINT_ID.equal(id)
					.and(MONTH_CONSTRAINT.ACTIVITY_ID.equal(activity.getId())))
				.returning().fetch();
		}
	}
}
