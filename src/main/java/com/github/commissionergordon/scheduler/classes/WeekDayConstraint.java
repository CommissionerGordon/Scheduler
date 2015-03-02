package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.Main;
import com.github.commissionergordon.scheduler.interfaces.Constraint;
import com.github.commissionergordon.scheduler.interfaces.SQLObject;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.github.commissionergordon.scheduler.jooq.generated.Tables.WEEKDAY_CONSTRAINT;

public class WeekDayConstraint implements Constraint, SQLObject {
    private int id;
	private Activity activity;
    private boolean can;


    public boolean monday;
    public boolean tuesday;
    public boolean wednesday;
    public boolean thursday;
    public boolean friday;
    public boolean saturday;
    public boolean sunday;

    public WeekDayConstraint(int id, Activity activity, boolean can, boolean sunday, boolean monday, boolean tuesday,
                             boolean wednesday, boolean thursday, boolean friday, boolean saturday) {
        this.id = id;
        this.activity = activity;
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
	public void update() throws SQLException {
		try(Connection conn = DriverManager.getConnection(Main.getDBConnectionString(), Main.getDbUser(), "")) {
			DSLContext database = DSL.using(conn);

			database.update(WEEKDAY_CONSTRAINT)
				.set(WEEKDAY_CONSTRAINT.CAN, can)
				.set(WEEKDAY_CONSTRAINT.MONDAY, monday)
				.set(WEEKDAY_CONSTRAINT.TUESDAY, tuesday)
				.set(WEEKDAY_CONSTRAINT.WEDNESDAY, wednesday)
				.set(WEEKDAY_CONSTRAINT.THURSDAY, thursday)
				.set(WEEKDAY_CONSTRAINT.FRIDAY, friday)
				.set(WEEKDAY_CONSTRAINT.SATURDAY, saturday)
				.set(WEEKDAY_CONSTRAINT.SUNDAY, sunday)
				.where(WEEKDAY_CONSTRAINT.WEEKDAY_CONSTRAINT_ID.equal(id)
					.and(WEEKDAY_CONSTRAINT.ACTIVITY_ID.equal(activity.getId())))
				.returning().fetch();
		}
	}
}
