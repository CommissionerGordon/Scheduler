package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.Main;
import com.github.commissionergordon.scheduler.interfaces.Constraint;
import com.github.commissionergordon.scheduler.interfaces.SQLObject;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import static com.github.commissionergordon.scheduler.jooq.generated.Tables.TIME_CONSTRAINT;

public class TimeConstraint implements Constraint, SQLObject {
    private int id;
    private Activity activity;
    private boolean can;

    private LocalTime startTime;
    private LocalTime endTime;

    public TimeConstraint(int id, Activity activity, boolean can, LocalTime startTime, LocalTime endTime){
        this.id = id;
        this.activity = activity;
        this.can = can;
        this.startTime = startTime;
        this.endTime = endTime;
    }

	@Override
	public void update() throws SQLException {
		try(Connection conn = DriverManager.getConnection(Main.getDBConnectionString(), Main.getDbUser(), "")) {
			DSLContext database = DSL.using(conn);

			database.update(TIME_CONSTRAINT)
				.set(TIME_CONSTRAINT.CAN, can)
				.set(TIME_CONSTRAINT.STARTTIME, Time.valueOf(startTime))
				.set(TIME_CONSTRAINT.ENDTIME, Time.valueOf(endTime))
				.where(TIME_CONSTRAINT.TIME_CONSTRAINT_ID.equal(id)
					.and(TIME_CONSTRAINT.ACTIVITY_ID.equal(activity.getId())))
				.returning().fetch();
		}
	}
}
