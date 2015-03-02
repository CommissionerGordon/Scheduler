package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.Main;
import com.github.commissionergordon.scheduler.interfaces.Constraint;
import com.github.commissionergordon.scheduler.interfaces.SQLObject;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.*;

import static com.github.commissionergordon.scheduler.jooq.generated.Tables.DATE_CONSTRAINT;


public class DateConstraint implements Constraint, SQLObject {
	private int id;
    private Activity activity;
	private boolean can;

    private Date date;

    public DateConstraint(int id, Activity activity, boolean can, Date date){
		this.id = id;
        this.activity = this.activity;
		this.can = can;
        this.date = date;
    }

	@Override
	public void update() throws SQLException {
		try(Connection conn = DriverManager.getConnection(Main.getDBConnectionString(), Main.getDbUser(), "")) {
			DSLContext database = DSL.using(conn);

			database.update(DATE_CONSTRAINT)
					.set(DATE_CONSTRAINT.DATE_CONSTRAINT_ID, id)
					.set(DATE_CONSTRAINT.CAN, can)
					.set(DATE_CONSTRAINT.DATE, date)
					.where(DATE_CONSTRAINT.DATE_CONSTRAINT_ID.equal(id)
						.and(DATE_CONSTRAINT.ACTIVITY_ID.equal(activity.getId())))
					.returning().fetch();
		}
	}
}
